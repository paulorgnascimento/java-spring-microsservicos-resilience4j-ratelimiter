package com.paulorgnascimento.cleanarchitecture.infrastructure.exception;

import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RateLimitExceptionHandler {

    @ExceptionHandler(RequestNotPermitted.class)
    public ResponseEntity<Object> handleRateLimitException(RequestNotPermitted ex) {
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("Chegamos ao limite de requisições. Por favor, faça um retry");
    }
}
