package com.healthsync.healthsync_backend.Doctor.Entity;

import com.healthsync.healthsync_backend.auth.Entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String specialization;
    private String qualification;
    private String contactNumber;
    private String clinicAddress;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
