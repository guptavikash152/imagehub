package com.myorg.imagehub.service;

import com.myorg.imagehub.exceptions.CustomException;
import com.myorg.imagehub.model.Credentials;
import com.myorg.imagehub.model.JWTToken;
import com.myorg.imagehub.model.UserRegistrationDetails;

public interface LoginService {

	void register(UserRegistrationDetails request) throws CustomException;

	JWTToken validateCredentials(Credentials request) throws CustomException;

}
