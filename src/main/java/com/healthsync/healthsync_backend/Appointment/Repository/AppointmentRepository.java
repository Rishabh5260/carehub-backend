package com.healthsync.healthsync_backend.Appointment.Repository;

import com.healthsync.healthsync_backend.Appointment.Entity.Appointment;
import com.healthsync.healthsync_backend.auth.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDoctor(User doctor);
    List<Appointment> findByPatient(User patient);
}
