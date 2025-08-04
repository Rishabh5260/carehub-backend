package com.healthsync.healthsync_backend.MedicalRecord.dto;

import lombok.Data;

import java.time.LocalDate;

@Data

public class MedicalRecordRequest {
    private Long patientId;
    private String diagnosis;
    private String notes;
    private LocalDate recordDate;
}
