package com.lessons.clinic.controllers;

import javax.security.auth.message.AuthException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lessons.clinic.domain.auth.LoginRequest;
import com.lessons.clinic.domain.auth.LoginResponse;
import com.lessons.clinic.domain.auth.RefreshLoginRequest;
import com.lessons.clinic.service.AuthService;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}

	@PostMapping("login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest authRequest) throws AuthException {
        final LoginResponse token = authService.login(authRequest);
        return ResponseEntity.ok(token);
    }

    @PostMapping("token")
    public ResponseEntity<LoginResponse> getNewAccessToken(@RequestBody RefreshLoginRequest request) throws AuthException {
        final LoginResponse token = authService.getAccessToken(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }

    @PostMapping("refresh")
    public ResponseEntity<LoginResponse> getNewRefreshToken(@RequestBody RefreshLoginRequest request) throws AuthException {
        final LoginResponse token = authService.refresh(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }

}
