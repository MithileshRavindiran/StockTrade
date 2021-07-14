package com.hr.stocktrades.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{

    private static final long serialVersionUID = 1L;

    /**
     * Exception handler method for not found  error
     * @param message not found exception message
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
