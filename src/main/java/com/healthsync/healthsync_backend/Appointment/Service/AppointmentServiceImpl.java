package com.healthsync.healthsync_backend.Appointment.Service;

import com.healthsync.healthsync_backend.Appointment.Entity.Appointment;
import com.healthsync.healthsync_backend.Appointment.Entity.AppointmentStatus;
import com.healthsync.healthsync_backend.Appointment.Repository.AppointmentRepository;
import com.healthsync.healthsync_backend.Appointment.dto.AppointmentRequest;
import com.healthsync.healthsync_backend.Appointment.dto.AppointmentResponse;
import com.healthsync.healthsync_backend.auth.Entity.User;
import com.healthsync.healthsync_backend.auth.repository.UserRepository;
import jakarta.persistence.Cacheable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class AppointmentServiceImpl implements AppointmentService{


    private final AppointmentRepository appointmentRepository;


    private final UserRepository userRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, UserRepository userRepository) {
        this.appointmentRepository = appointmentRepository;
        this.userRepository = userRepository;
    }

    @Override
    public AppointmentResponse bookAppointment(AppointmentRequest request, User patient) {
        User doctor = userRepository.findById(request.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        Appointment appointment = Appointment.builder()
                .patient(patient)
                .doctor(doctor)
                .reason(request.getReason())
                .appointmentDateTime(request.getAppointmentDateTime())
                .status(AppointmentStatus.PENDING)
                .build();

        Appointment saved = appointmentRepository.save(appointment);
        return mapToResponse(saved);
    }
    @Override
    public List<AppointmentResponse> getAppointmentsForPatient(User patient) {
        return appointmentRepository.findByPatient(patient)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentResponse> getAppointmentsForDoctor(User doctor) {
        return appointmentRepository.findByDoctor(doctor)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
    String meetingLink = "https://meet.jit.si/" + UUID.randomUUID().toString();
    private AppointmentResponse mapToResponse(Appointment appointment) {
        return AppointmentResponse.builder()
                .id(appointment.getId())
                .doctorName(appointment.getDoctor().getFullName())
                .patientName(appointment.getPatient().getFullName())
                .reason(appointment.getReason())
                .appointmentDateTime(appointment.getAppointmentDateTime())
                .status(appointment.getStatus())
                .meetingLink(appointment.getMeetingLink())
                .build();
    }
}
