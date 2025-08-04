package com.healthsync.healthsync_backend.Patient.Service;

import com.healthsync.healthsync_backend.Patient.Entity.Patient;
import com.healthsync.healthsync_backend.Patient.Repository.PatientRepository;
import com.healthsync.healthsync_backend.auth.Entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Optional<Patient> getPatientByUser(User user) {
        return patientRepository.findByUser(user);
    }
}
