package com.customerservice.customexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class CustomException extends Exception {

	public CustomException(String exceptionMessage) {
		super(exceptionMessage);

	}
	
}
