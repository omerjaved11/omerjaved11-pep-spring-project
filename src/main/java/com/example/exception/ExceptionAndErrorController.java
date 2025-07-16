package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResponseExtractor;

@RestControllerAdvice
public class ExceptionAndErrorController {
    
@ExceptionHandler(DuplicateUsernameException.class)
@ResponseStatus(HttpStatus.CONFLICT)
public String handleDuplicateUsername(DuplicateUsernameException ex){
return ex.getMessage();
}

@ExceptionHandler(IllegalArgumentException.class)
@ResponseStatus(HttpStatus.BAD_REQUEST)
public String handleIlegalArgument(IllegalArgumentException ex){
    return ex.getMessage();
}

@ExceptionHandler(Exception.class)
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public String handleException(Exception ex){
    return ex.getMessage();
}

@ExceptionHandler(UnauthorizedException.class)
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public String handleUnauthorized(UnauthorizedException ex){
    return ex.getMessage();
}

}
