package com.myorg.imagehub.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import com.myorg.imagehub.exceptions.CustomException;
import com.myorg.imagehub.model.UserProfile;
import com.myorg.imagehub.repo.UserRepository;

@Service
public class ProfileServiceImpl implements ProfileService{

	@Autowired
	private UserRepository UserRepository;
	
	@Override
	public UserProfile getProfile(String userId) throws CustomException {
		
		Optional<UserProfile> optnlProfile = UserRepository.findById(userId);
		
		if(optnlProfile.isEmpty()) {
			throw new CustomException("profile not found", HttpStatusCode.valueOf(404));
		}else {
			return optnlProfile.get();
		}
	}

}
