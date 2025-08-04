package com.healthsync.healthsync_backend.MedicalRecord.Controller;


import com.healthsync.healthsync_backend.MedicalRecord.Service.MedicalRecordService;
import com.healthsync.healthsync_backend.MedicalRecord.dto.MedicalRecordRequest;
import com.healthsync.healthsync_backend.MedicalRecord.dto.MedicalRecordResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/records")
@RequiredArgsConstructor
public class MedicalRecordController {
    private final MedicalRecordService recordService;

    @PreAuthorize("hasAuthority('DOCTOR')")
    @PostMapping
    public ResponseEntity<String> createRecord(@RequestBody MedicalRecordRequest request) {
        recordService.createMedicalRecord(request);
        return ResponseEntity.ok("Medical record created successfully");
    }

    @PreAuthorize("hasAnyAuthority('DOCTOR', 'PATIENT')")
    @GetMapping
    public ResponseEntity<List<MedicalRecordResponse>> getMyRecords() {
        return ResponseEntity.ok(recordService.getRecordsForCurrentUser());
    }
}
