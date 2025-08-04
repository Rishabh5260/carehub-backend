package com.healthsync.healthsync_backend.auth.dto;

import com.healthsync.healthsync_backend.common.enums.UserRole;
import lombok.Data;

@Data
public class RegisterRequest {
    private String fullName;
    private String email;
    private String password;
    private UserRole role;
}
