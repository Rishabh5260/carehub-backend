package com.healthsync.healthsync_backend.Patient.Controller;


import com.healthsync.healthsync_backend.Patient.Entity.Patient;
import com.healthsync.healthsync_backend.Patient.Service.PatientService;
import com.healthsync.healthsync_backend.auth.Entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/create")
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }

    @GetMapping("/me")
    public Patient getPatientProfile(@AuthenticationPrincipal User user) {
        return patientService.getPatientByUser(user)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }
}
