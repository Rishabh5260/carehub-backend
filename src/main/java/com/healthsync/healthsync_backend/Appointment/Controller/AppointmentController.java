package com.healthsync.healthsync_backend.Appointment.Controller;


import com.healthsync.healthsync_backend.Appointment.Service.AppointmentService;
import com.healthsync.healthsync_backend.Appointment.dto.AppointmentRequest;
import com.healthsync.healthsync_backend.Appointment.dto.AppointmentResponse;
import com.healthsync.healthsync_backend.auth.Entity.User;
import com.healthsync.healthsync_backend.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final UserRepository userRepository;
    @PostMapping("/book")
    public AppointmentResponse bookAppointment(@RequestBody AppointmentRequest request,
                                               @AuthenticationPrincipal UserDetails userDetails) {
        User patient = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        return appointmentService.bookAppointment(request, patient);
    }

    @GetMapping("/patient")
    public List<AppointmentResponse> getMyAppointments(@AuthenticationPrincipal UserDetails userDetails) {
        User patient = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        return appointmentService.getAppointmentsForPatient(patient);
    }

    @GetMapping("/doctor")
    public List<AppointmentResponse> getDoctorAppointments(@AuthenticationPrincipal UserDetails userDetails) {
        User doctor = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
        return appointmentService.getAppointmentsForDoctor(doctor);
    }
}
