package com.healthsync.healthsync_backend.MedicalRecord.Repository;

import com.healthsync.healthsync_backend.MedicalRecord.Entity.MedicalRecord;
import com.healthsync.healthsync_backend.auth.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
    List<MedicalRecord> findByPatient(User patient);
    List<MedicalRecord> findByDoctor(User doctor);
}
