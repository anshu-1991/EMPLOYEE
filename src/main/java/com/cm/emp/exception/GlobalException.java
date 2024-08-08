package com.cm.emp.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cm.emp.bean.ErrorResponse;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(value = Exception.class)
	public final ResponseEntity<Object> handelAllException(Exception ex) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse errorResponse = new ErrorResponse( details,"server error",HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<Object>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = EmployeeException.class)
	public final ResponseEntity<Object> employeeException(EmployeeException ex) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse errorResponse = new ErrorResponse( details,"Not Found",HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<Object>(errorResponse, HttpStatus.NOT_FOUND);
	}

}
