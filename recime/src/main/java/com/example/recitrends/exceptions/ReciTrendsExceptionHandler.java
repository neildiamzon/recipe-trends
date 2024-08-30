package com.example.recitrends.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.example.recitrends.dto.ResponseMessage;

@ControllerAdvice
public class ReciTrendsExceptionHandler {
	
	@ExceptionHandler({MethodArgumentTypeMismatchException.class, 
		UnsatisfiedServletRequestParameterException.class})
	public ResponseEntity<ResponseMessage> handleMethodArguementTypeMismatchException(
			Exception e){
		String message = "A difficulty is required for filtering trending recipes.";
        return new ResponseEntity<>(new ResponseMessage(message), HttpStatus.BAD_REQUEST);
	}

}
