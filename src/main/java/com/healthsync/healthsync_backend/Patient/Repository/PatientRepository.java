package com.healthsync.healthsync_backend.Patient.Repository;

import com.healthsync.healthsync_backend.Patient.Entity.Patient;
import com.healthsync.healthsync_backend.auth.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByUser(User user);
}
