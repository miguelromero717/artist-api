package com.miguelromero717.artistapi.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class APIExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ArtistNotFoundException.class})
    public ResponseEntity<APIError> handleArtistNotFoundException(ArtistNotFoundException exception) {
        return ResponseEntity.badRequest().body(new APIError(exception.getMessage()));
    }
}
