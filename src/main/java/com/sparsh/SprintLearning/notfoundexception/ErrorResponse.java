package com.sparsh.SprintLearning.notfoundexception;

import com.sparsh.SprintLearning.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class ErrorResponse extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMessage> departmentNotFoundException(NotFoundException notFoundException, WebRequest request){
       ErrorMessage message= new ErrorMessage(HttpStatus.NOT_FOUND,notFoundException.getMessage());
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
