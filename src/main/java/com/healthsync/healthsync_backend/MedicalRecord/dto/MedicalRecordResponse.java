package com.healthsync.healthsync_backend.MedicalRecord.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class MedicalRecordResponse {
    private Long id;
    private String diagnosis;
    private String notes;
    private LocalDate recordDate;
    private String doctorName;
    private String patientName;

}
