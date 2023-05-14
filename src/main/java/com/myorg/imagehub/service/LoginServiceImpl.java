package com.myorg.imagehub.service;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Optional;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import com.myorg.imagehub.crypto.AppCrypto;
import com.myorg.imagehub.exceptions.CustomException;
import com.myorg.imagehub.model.Credentials;
import com.myorg.imagehub.model.JWTToken;
import com.myorg.imagehub.model.UserProfile;
import com.myorg.imagehub.model.UserRegistrationDetails;
import com.myorg.imagehub.repo.CredentialsRepository;
import com.myorg.imagehub.repo.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private CredentialsRepository credentialsRepository;
	
	@Autowired
	private UserRepository UserRepository;
	
	@Autowired
	private AppCrypto crypto;
	
	@Value("${jwt.key}")
	private String jwtKey;
	
	@Override
	public void register(UserRegistrationDetails request) throws CustomException {
		
		Credentials creds = request.getCreds();
		
		boolean isUserIdExists = credentialsRepository.existsById(creds.getUserId());
		
		if(isUserIdExists) {
			throw new CustomException("user id already registered", HttpStatusCode.valueOf(422));
		}
		
		creds.setPassword(crypto.encodePassword(creds.getPassword()));
		
		credentialsRepository.save(creds);
		
		UserProfile profile = new UserProfile();
		profile.setUserId(request.getCreds().getUserId());
		profile.setFullName(request.getFullName());
		profile.setGender(request.getGender());
		profile.setAge(request.getAge());
		
		UserRepository.save(profile);
		
	}

	@Override
	public JWTToken validateCredentials(Credentials request) throws CustomException{
		
		Optional<Credentials> optnlUserCreds = credentialsRepository.findById(request.getUserId());
		Credentials userCreds = null;
		JWTToken token = null;
		if(optnlUserCreds.isEmpty()) {
			throw new CustomException("user id not found", HttpStatusCode.valueOf(404));
		}else {
			
			userCreds = optnlUserCreds.get();
			
			boolean isMatched = crypto.verifyPassword(request.getPassword(), userCreds.getPassword());
			
			if(isMatched) {
				token = new JWTToken();
				SecretKey key = Keys.hmacShaKeyFor(jwtKey.getBytes(StandardCharsets.UTF_8));
		    	String jwt = Jwts.builder()
		    			.setIssuer("ImageHub")
		    			.setSubject("JWT Token")
		    			.claim("userid", request.getUserId())
		    			.setIssuedAt(new Date())
		    			.setExpiration(new Date((new Date()).getTime() + 30000000))
		    			.signWith(key).compact();
		    	token.setToken(jwt);
				
			}else {
				throw new CustomException("User Id or Password is incorrect", HttpStatusCode.valueOf(401));
			}
		}
		
		return token;
	}

}
