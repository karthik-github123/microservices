package com.loyalty.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.loyalty.resource.CustomerController;

@ControllerAdvice(basePackageClasses = CustomerController.class)
public class ServiceExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ServiceException.class)
	@ResponseBody
	ResponseEntity<?> handleControllerException(HttpServletRequest request,
			Throwable ex) {
		Integer errorCode = ((ServiceException) ex).getErrorCode();
		Integer statusCode = ((ServiceException) ex).getStatusCode();
		HttpStatus status = HttpStatus.valueOf(statusCode);
		return new ResponseEntity<>(new ServiceErrorResponse(errorCode,
				ex.getMessage()), status);
	}
}