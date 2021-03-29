package Controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.HttpStatus;
import classes.AbnNotFoundException;

@ControllerAdvice
public class AbnNotFoundAdvice {
    
	  @ResponseBody
	  @ExceptionHandler(AbnNotFoundException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  String employeeNotFoundHandler(AbnNotFoundException ex) {
	    return ex.getMessage();
	  }
}
