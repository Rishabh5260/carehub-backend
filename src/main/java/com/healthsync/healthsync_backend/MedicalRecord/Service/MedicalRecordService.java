package com.healthsync.healthsync_backend.MedicalRecord.Service;

import com.healthsync.healthsync_backend.MedicalRecord.Entity.MedicalRecord;
import com.healthsync.healthsync_backend.MedicalRecord.Repository.MedicalRecordRepository;
import com.healthsync.healthsync_backend.MedicalRecord.dto.MedicalRecordRequest;
import com.healthsync.healthsync_backend.MedicalRecord.dto.MedicalRecordResponse;
import com.healthsync.healthsync_backend.auth.Entity.User;
import com.healthsync.healthsync_backend.auth.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalRecordService {
    private final MedicalRecordRepository recordRepository;
    private final UserRepository userRepository;

    public MedicalRecordService(MedicalRecordRepository recordRepository, UserRepository userRepository) {
        this.recordRepository = recordRepository;
        this.userRepository = userRepository;
    }

    public void createMedicalRecord(MedicalRecordRequest request) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User doctor = userRepository.findByEmail(email).orElseThrow();
        User patient = userRepository.findById(request.getPatientId()).orElseThrow();

        MedicalRecord record = MedicalRecord.builder()
                .diagnosis(request.getDiagnosis())
                .notes(request.getNotes())
                .recordDate(request.getRecordDate())
                .doctor(doctor)
                .patient(patient)
                .build();

        recordRepository.save(record);
    }

    public List<MedicalRecordResponse> getRecordsForCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email).orElseThrow();

        List<MedicalRecord> records = user.getRole().name().equals("PATIENT") ?
                recordRepository.findByPatient(user) :
                recordRepository.findByDoctor(user);

        return records.stream().map(record -> MedicalRecordResponse.builder()
                .id(record.getId())
                .diagnosis(record.getDiagnosis())
                .notes(record.getNotes())
                .recordDate(record.getRecordDate())
                .doctorName(record.getDoctor().getFullName())
                .patientName(record.getPatient().getFullName())
                .build()
        ).collect(Collectors.toList());
    }
}
