package com.healthsync.healthsync_backend.Doctor.Service;

import com.healthsync.healthsync_backend.Doctor.Entity.Doctor;
import com.healthsync.healthsync_backend.Doctor.Repository.DoctorRepository;
import com.healthsync.healthsync_backend.auth.Entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Optional<Doctor> getDoctorByUser(User user) {
        return doctorRepository.findByUser(user);
    }
}
