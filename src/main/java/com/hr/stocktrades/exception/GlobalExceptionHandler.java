package com.hr.stocktrades.exception;

import com.hr.stocktrades.model.dto.Error;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Method to handle the constraint violation exception
     * @param ex of type {@link MethodArgumentNotValidException}
     * @param headers holds the  http headers
     * @param status hold the http statu
     * @param request hold the WebRequest
     * @return response entity with  the  Bad request status code
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        Error error = Error.builder()
                .message(ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage())
                .date(new Date()).build();

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * Method to  handle the Resource not  found exception which returns 404
     * @param ex the resource not found exception
     * @return response entity  with exception message and Not found  status code
     */
    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<Object> resourceNotFoundException(ResourceNotFoundException ex) {
        Error error = Error.builder()
                .message(ex.getMessage())
                .date(new Date())
                .build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


}
