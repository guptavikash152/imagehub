package com.myorg.imagehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.myorg.imagehub.exceptions.CustomException;
import com.myorg.imagehub.model.UserProfile;
import com.myorg.imagehub.service.ProfileService;

@RestController
public class ProfileController {

	@Autowired
	private ProfileService profileService;

	@GetMapping("/get-profile/{userId}")
	public ResponseEntity<?> getProfile(@PathVariable String userId) throws CustomException {
		UserProfile profile = profileService.getProfile(userId);
		return new ResponseEntity<>(profile, HttpStatusCode.valueOf(200));
	}
	
}
