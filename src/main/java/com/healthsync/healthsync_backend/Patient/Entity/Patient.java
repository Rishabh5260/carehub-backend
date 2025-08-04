package com.healthsync.healthsync_backend.Patient.Entity;

import com.healthsync.healthsync_backend.auth.Entity.User;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private LocalDate dateOfBirth;
    private String gender;
    private String contactNumber;
    private String address;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
