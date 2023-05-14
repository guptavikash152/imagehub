package com.myorg.imagehub.service;

import com.myorg.imagehub.exceptions.CustomException;
import com.myorg.imagehub.model.UserProfile;

public interface ProfileService {

	public UserProfile getProfile(String userId) throws CustomException;
	
}
