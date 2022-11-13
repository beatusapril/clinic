package com.lessons.clinic.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lessons.clinic.domain.auth.JwtAuthentication;
import com.lessons.clinic.service.AuthService;

@RestController
@RequestMapping("api")
public class HelloController {
	
	private final AuthService authService;

	public HelloController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	
    @GetMapping("hello/user")
    public ResponseEntity<String> helloUser() {
        final JwtAuthentication authInfo = authService.getAuthInfo();
        return ResponseEntity.ok("Hello user " + authInfo.getPrincipal() + "!");
    }

}
