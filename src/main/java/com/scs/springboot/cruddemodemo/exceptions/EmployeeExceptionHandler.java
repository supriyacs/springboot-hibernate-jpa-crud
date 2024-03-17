package com.scs.springboot.cruddemodemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {


  @ExceptionHandler
  public ResponseEntity<ErrorResponse>employeeNotFoundExceptionHandler(EmployeeNotFoundException e){
    ErrorResponse errorResponse=new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage(),System.currentTimeMillis());
   return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
  }

}
