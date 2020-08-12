package com.hibernatevalidator.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hibernatevalidator.entity.ResponseError;

@ControllerAdvice
public class GlobalErrorHandler {
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseBody
	public ResponseError handleCustomException(ConstraintViolationException ex) {
		ResponseError responseError = new ResponseError();
		List<String> errorMessages = new ArrayList();
		for (ConstraintViolation constraintViolation : ex.getConstraintViolations()) {
			errorMessages.add(constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage());
		}
		responseError.setErrorMessage(errorMessages);
		responseError.setStatusCode(HttpStatus.BAD_REQUEST.value());
		return responseError;

	}
}
