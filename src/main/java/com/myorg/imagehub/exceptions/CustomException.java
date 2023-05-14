package com.myorg.imagehub.exceptions;

import org.springframework.http.HttpStatusCode;

public class CustomException extends Exception{
	
	HttpStatusCode statusCode;
	
	public CustomException(String msg, HttpStatusCode statusCode) {
		super(msg);
		this.statusCode = statusCode;
	}

	public HttpStatusCode getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(HttpStatusCode statusCode) {
		this.statusCode = statusCode;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = -3695054223404454053L;
	

}
