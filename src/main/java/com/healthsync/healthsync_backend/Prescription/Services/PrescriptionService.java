package com.healthsync.healthsync_backend.Prescription.Services;

import com.healthsync.healthsync_backend.Doctor.Entity.Doctor;
import com.healthsync.healthsync_backend.Doctor.Repository.DoctorRepository;
import com.healthsync.healthsync_backend.Patient.Entity.Patient;
import com.healthsync.healthsync_backend.Patient.Repository.PatientRepository;
import com.healthsync.healthsync_backend.Prescription.Repository.PrescriptionRepository;
import com.healthsync.healthsync_backend.Prescription.dto.PrescriptionRequest;
import com.healthsync.healthsync_backend.Prescription.dto.PrescriptionResponse;
import com.healthsync.healthsync_backend.Prescription.entity.Prescription;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PrescriptionService {
    private final PrescriptionRepository prescriptionRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public void createPrescription(PrescriptionRequest request) {
        Patient patient = patientRepository.findById(request.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Doctor doctor = doctorRepository.findById(request.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        Prescription prescription = Prescription.builder()
                .description(request.getDescription())
                .issuedAt(LocalDateTime.now())
                .patient(patient)
                .doctor(doctor)
                .build();

        prescriptionRepository.save(prescription);
    }
    public List<PrescriptionResponse> getPrescriptionsForPatient(Long patientId) {
        return prescriptionRepository.findByPatientId(patientId)
                .stream()
                .map(p -> PrescriptionResponse.builder()
                        .id(p.getId())
                        .description(p.getDescription())
                        .doctorName("Doctor Name") // error in this part
                        .patientName("Patient Name")
                        .issuedAt(p.getIssuedAt())
                        .build())
                .collect(Collectors.toList());
    }
    public List<PrescriptionResponse> getPrescriptionsForDoctor(Long doctorId) {
        return prescriptionRepository.findByDoctorId(doctorId)
                .stream()
                .map(p -> PrescriptionResponse.builder()
                        .id(p.getId())
                        .description(p.getDescription())
                        .doctorName("Doctor Name")
                        .patientName("Patient Name")
                        .issuedAt(p.getIssuedAt())
                        .build())
                .collect(Collectors.toList());
    }
}
