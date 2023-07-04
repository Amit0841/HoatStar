package com.masai.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class InvalidDataExceptio {
	
@ExceptionHandler(IllegalArgumentException.class)
public ResponseEntity<String> invalidDataException(IllegalArgumentException ie) {
	
	return new ResponseEntity<String>(ie.getMessage(),HttpStatus.BAD_REQUEST);
	
}
}
