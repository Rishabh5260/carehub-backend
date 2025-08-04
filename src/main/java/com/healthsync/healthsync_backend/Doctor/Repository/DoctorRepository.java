package com.healthsync.healthsync_backend.Doctor.Repository;

import com.healthsync.healthsync_backend.Doctor.Entity.Doctor;
import com.healthsync.healthsync_backend.auth.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findByUser(User user);
}
