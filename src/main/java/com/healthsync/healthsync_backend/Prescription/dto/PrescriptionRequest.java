package com.healthsync.healthsync_backend.Prescription.dto;
import lombok.Data;


@Data
public class PrescriptionRequest {
    private String description;
    private Long patientId;
    private Long doctorId;
}
