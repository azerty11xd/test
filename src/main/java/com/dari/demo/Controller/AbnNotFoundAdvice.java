package com.dari.demo.Controller;

import com.dari.demo.classes.AbnNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.HttpStatus;

@ControllerAdvice
public class AbnNotFoundAdvice {
    
	  @ResponseBody
	  @ExceptionHandler(AbnNotFoundException .class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  String employeeNotFoundHandler(AbnNotFoundException ex) {
	    return ex.getMessage();
	  }
}
