package com.healthsync.healthsync_backend.Prescription.dto;

import com.healthsync.healthsync_backend.Doctor.Entity.Doctor;
import com.healthsync.healthsync_backend.Patient.Entity.Patient;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PrescriptionResponse {
    private Long id;
    private String description;
    private String doctorName;
    private String patientName;
    private LocalDateTime issuedAt;
    private Doctor doctor;
    private Patient patient;
}
