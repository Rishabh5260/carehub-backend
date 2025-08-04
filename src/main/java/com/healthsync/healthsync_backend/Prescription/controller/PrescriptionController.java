package com.healthsync.healthsync_backend.Prescription.controller;

import com.healthsync.healthsync_backend.Prescription.Services.PrescriptionService;
import com.healthsync.healthsync_backend.Prescription.dto.PrescriptionRequest;
import com.healthsync.healthsync_backend.Prescription.dto.PrescriptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class PrescriptionController {
    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('DOCTOR')")
    public ResponseEntity<?> createPrescription(@RequestBody PrescriptionRequest request) {
        prescriptionService.createPrescription(request);
        return ResponseEntity.ok("Prescription created successfully");
    }

    @GetMapping("/patient/{patientId}")
    @PreAuthorize("hasAuthority('PATIENT')")
    public ResponseEntity<List<PrescriptionResponse>> getPatientPrescriptions(@PathVariable Long patientId) {
        return ResponseEntity.ok(prescriptionService.getPrescriptionsForPatient(patientId));
    }

    @GetMapping("/doctor/{doctorId}")
    @PreAuthorize("hasAuthority('DOCTOR')")
    public ResponseEntity<List<PrescriptionResponse>> getDoctorPrescriptions(@PathVariable Long doctorId) {
        return ResponseEntity.ok(prescriptionService.getPrescriptionsForDoctor(doctorId));
    }
}
