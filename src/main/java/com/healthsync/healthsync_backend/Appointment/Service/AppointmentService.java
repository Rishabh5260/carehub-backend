package com.healthsync.healthsync_backend.Appointment.Service;

import com.healthsync.healthsync_backend.Appointment.dto.AppointmentRequest;
import com.healthsync.healthsync_backend.Appointment.dto.AppointmentResponse;
import com.healthsync.healthsync_backend.auth.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AppointmentService {
    AppointmentResponse bookAppointment(AppointmentRequest request, User patient);
    List<AppointmentResponse> getAppointmentsForPatient(User patient);
    List<AppointmentResponse> getAppointmentsForDoctor(User doctor);
}
