package com.healthsync.healthsync_backend.auth.Controller;
import com.healthsync.healthsync_backend.auth.Services.AuthServices;
import com.healthsync.healthsync_backend.auth.dto.LoginRequest;
import com.healthsync.healthsync_backend.auth.dto.LoginResponse;
import com.healthsync.healthsync_backend.auth.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthServices authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        String response = authService.register(request);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
