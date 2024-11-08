package com.project.easyEvent.common.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@AllArgsConstructor
@Getter
@Builder
public class ValidationErrorResponse {

    private String message;
    private String field;

    static public ValidationErrorResponse from(FieldError error) {
        return ValidationErrorResponse.builder()
                .message(error.getDefaultMessage())
                .field(error.getField())
                .build();
    }
}
