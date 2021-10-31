package com.ismael.homework.main.Config;

import com.ismael.homework.main.Entity.Response;
import com.ismael.homework.main.Exception.ResourceNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public Response handle(ResourceNotFoundException e){
        return new Response(e.getMessage(),null);
    }
    @ExceptionHandler(BadCredentialsException.class)
    public Response handle(BadCredentialsException e){
        return new Response(e.getMessage(),null);
    }
}
