package com.customerservice.statusoverrideexception;


import com.customerservice.customexceptions.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StatusOverrideException {

    @ExceptionHandler({CustomException.class})
    public ResponseEntity<String> handleRunTimeException(CustomException e) {
        return error(HttpStatus.NOT_FOUND, e);
    }

    private ResponseEntity<String> error(HttpStatus status, Exception e) {

        return ResponseEntity.status(status).body(e.getMessage());
    }

}
