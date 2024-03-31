package com.example.policyserviceproject.error;

import com.example.policyserviceproject.model.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(HandleUserException.class)
    public final ResponseEntity<ErrorDetails> handleUserNotFoundException(HandleUserException ex) {
        ErrorDetails errorDetails = new ErrorDetails("E" , ex.getErrorCode() ,ex.getErrorMessage());
        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
    }
}
