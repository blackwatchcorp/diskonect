package com.blackwatch.diskonect.model.response;

import jakarta.annotation.Nullable;
import org.springframework.http.HttpStatusCode;

import java.util.Map;

public record ExceptionResponse(
    String message, HttpStatusCode status, @Nullable Map<String, String> errors) {}
