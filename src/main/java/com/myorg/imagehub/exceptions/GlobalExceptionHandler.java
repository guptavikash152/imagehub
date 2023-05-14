package com.myorg.imagehub.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(CustomException.class)
    protected ResponseEntity<ErrorInfo> handleCustomException(CustomException ex, WebRequest request) {
		  
		ErrorInfo error = new ErrorInfo();
		error.setDesc(ex.getMessage());
		return new ResponseEntity<>(error, ex.getStatusCode());
	}
	
	@ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorInfo> handleOtherExcpetions(RuntimeException ex, WebRequest request) {
		  
		ErrorInfo error = new ErrorInfo();
		error.setDesc(ex.getMessage());
		return new ResponseEntity<>(error, HttpStatusCode.valueOf(503));
	}
	
}
