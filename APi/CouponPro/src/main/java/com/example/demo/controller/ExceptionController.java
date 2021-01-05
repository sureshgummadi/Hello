package com.example.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.ApiError;
import com.example.demo.exception.CouponNotFoundException;
import com.example.demo.exception.ValidationError;

@RestControllerAdvice
public class ExceptionController {
	@Autowired
	private ApiError api;

	@ExceptionHandler(value = CouponNotFoundException.class)
	public ResponseEntity<ApiError> noCouponFound() {
		ApiError error = new ApiError();
		error.setErrorCode("400");
		error.setErrorDesc("No Coupon Found ");
		error.setErrorDate(new Date());
		return new ResponseEntity<ApiError>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = ValidationError.class)
	public ResponseEntity<ApiError> validationError() {
		api.setErrorCode("400");
		api.setErrorDesc("Please Provide Valid Details");
		api.setErrorDate(new Date());
		return new ResponseEntity<ApiError>(api, HttpStatus.BAD_REQUEST);
	}

}
