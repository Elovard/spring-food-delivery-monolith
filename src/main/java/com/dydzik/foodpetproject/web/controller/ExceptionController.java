package com.dydzik.foodpetproject.web.controller;

import com.dydzik.foodpetproject.dto.ErrorResponse;
import com.dydzik.foodpetproject.exception.ClientNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ClientNotFoundException.class)
	public ResponseEntity<ErrorResponse> clientNotFoundExceptionHandler(ClientNotFoundException e) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setTimestamp(LocalDateTime.now().toString());
		errorResponse.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
		errorResponse.setCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
		errorResponse.setMessage(e.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
}


