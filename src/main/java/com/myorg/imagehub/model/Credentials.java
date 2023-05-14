package com.myorg.imagehub.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "USER_CREDENTIALS")
public class Credentials {

	@NotEmpty(message = "user name is required")
	@Id
	@Column
	private String userId;
	
	@NotEmpty(message = "password is required")
	@Size(min = 4)
	@Column
	private String password;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
