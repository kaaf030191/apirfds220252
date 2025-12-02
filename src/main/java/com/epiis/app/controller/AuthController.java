package com.epiis.app.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epiis.app.JwtService;
import com.epiis.app.auxobject.Users;

@RestController
@RequestMapping("auth")
public class AuthController {
	private final JwtService jwtService;

	public AuthController(
		JwtService jwtService
	) {
		this.jwtService = jwtService;
	}

	record LoginRequest(String userName, String password) {}
	record AuthResponse(String token) {}

	@PostMapping(path = "login", consumes = "multipart/form-data")
	public ResponseEntity<AuthResponse> login(@ModelAttribute LoginRequest request) {
		try {
			Optional<Map<String, String>> data = Users.listUser.stream()
				.filter(userMap -> request.userName().equals(userMap.get("userName")) && request.password().equals(userMap.get("password")))
				.findFirst();
			
			if(data.isPresent()) {
				String jwtToken = jwtService.generateToken(data.get());

				return ResponseEntity.ok(new AuthResponse(jwtToken));
			} else {
				return ResponseEntity.status(401).build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(401).build();
		}
	}
}