package com.myorg.imagehub.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class UserRegistrationDetails {

	@NotEmpty(message = "Full Name is required")
	private String fullName;
	
	@NotEmpty(message = "Gender is required")
	private String gender;
	
	@NotNull(message = "Age is required")
	@Positive
	private int age;
	
	@Valid
	@NotNull
	private Credentials creds;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Credentials getCreds() {
		return creds;
	}
	public void setCreds(Credentials creds) {
		this.creds = creds;
	}
	
}
