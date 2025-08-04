package com.healthsync.healthsync_backend.Appointment.dto;

import com.healthsync.healthsync_backend.Appointment.Entity.AppointmentStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
@Builder
public class AppointmentResponse {
    private Long id;
    private String doctorName;
    private String patientName;
    private String reason;
    private LocalDateTime appointmentDateTime;
    private AppointmentStatus status;
    private String meetingLink;
}
