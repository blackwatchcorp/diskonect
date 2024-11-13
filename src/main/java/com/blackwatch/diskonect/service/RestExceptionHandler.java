package com.blackwatch.diskonect.service;

import com.blackwatch.diskonect.exception.RestStatusException;
import com.blackwatch.diskonect.model.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(RestStatusException.class)
  public ResponseEntity<ExceptionResponse> handleRestStatusException(RestStatusException e) {
    return ResponseEntity.status(e.getStatusCode())
        .body(new ExceptionResponse(e.getReason(), e.getStatusCode(), null));
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<ExceptionResponse> handleServerError(RuntimeException e) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(
            new ExceptionResponse("INTERNAL SERVER ERROR", HttpStatus.INTERNAL_SERVER_ERROR, null));
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ExceptionResponse> handleValidationException(
      MethodArgumentNotValidException e) {
    Map<String, String> errors = new HashMap<>();
    e.getBindingResult()
        .getFieldErrors()
        .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(new ExceptionResponse("Invalid parameters", HttpStatus.BAD_REQUEST, errors));
  }
}
