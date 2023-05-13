package com.myorg.imagehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myorg.imagehub.crypto.AppCrypto;
import com.myorg.imagehub.model.Credentials;

@RestController
public class TestController {
	
	@Autowired
	private AppCrypto crypto;
	
	@PostMapping("login")
	public ResponseEntity<?> login(@RequestBody Credentials creds){
		
		String encrypted = crypto.encrypt(creds.getPassword());
		
		String plainPassword = crypto.decrypt(encrypted);
		
		if(creds.getPassword().equals(plainPassword)) {
			System.out.println("RSA working as expected");
		}
		
		return null;
	}

}
