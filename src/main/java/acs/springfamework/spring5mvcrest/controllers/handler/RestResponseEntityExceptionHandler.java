package acs.springfamework.spring5mvcrest.controllers.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import acs.springfamework.spring5mvcrest.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler({ResourceNotFoundException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleNotFoundException(Exception exception, WebRequest request) {
		
		log.info("An exception will be throw: " + exception.getMessage());

		return "Resource not found";
		
	}
	

}
