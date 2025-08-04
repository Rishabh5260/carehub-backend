package com.healthsync.healthsync_backend.Appointment.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentRequest {
    private Long doctorId;
    private String reason;
    private LocalDateTime appointmentDateTime;
}
