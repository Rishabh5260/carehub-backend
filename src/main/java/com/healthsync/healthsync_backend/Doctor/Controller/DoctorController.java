package com.healthsync.healthsync_backend.Doctor.Controller;


import com.healthsync.healthsync_backend.Doctor.Entity.Doctor;
import com.healthsync.healthsync_backend.Doctor.Service.DoctorService;
import com.healthsync.healthsync_backend.auth.Entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/create")
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorService.createDoctor(doctor);
    }

    @GetMapping("/me")
    public Doctor getDoctorProfile(@AuthenticationPrincipal User user) {
        return doctorService.getDoctorByUser(user)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
    }
}
