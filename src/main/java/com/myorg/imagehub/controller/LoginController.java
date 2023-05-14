package com.myorg.imagehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myorg.imagehub.exceptions.CustomException;
import com.myorg.imagehub.model.Credentials;
import com.myorg.imagehub.model.JWTToken;
import com.myorg.imagehub.model.UserRegistrationDetails;
import com.myorg.imagehub.service.LoginService;

import jakarta.validation.Valid;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody @Valid UserRegistrationDetails request) throws CustomException{
		
		loginService.register(request);
		
		return new ResponseEntity<>(HttpStatusCode.valueOf(201));
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody @Valid Credentials request) throws CustomException{
		
		JWTToken token = loginService.validateCredentials(request);
		
		return new ResponseEntity<>(token, HttpStatusCode.valueOf(200));
	}
}
