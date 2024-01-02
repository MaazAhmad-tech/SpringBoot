package com.springcourse.demo.rest;

import com.springcourse.demo.exceptions.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    //add exception handling code here which will be global since @ControllerAdvice is used
    //Add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception)
    {
        //create the StudentErrorResponse error object
        StudentErrorResponse error = new StudentErrorResponse();

        //set the values to the error object
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimestamp(String.valueOf(System.currentTimeMillis()));

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //add another exception handler to catch other Exceptions(catch all)
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleAllException(Exception e){

        //create the StudentErrorResponse error object
        StudentErrorResponse error = new StudentErrorResponse();

        //set the values to the error object
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e.getMessage());
        error.setTimestamp(String.valueOf(System.currentTimeMillis()));

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
