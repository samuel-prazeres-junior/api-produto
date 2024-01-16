package com.github.produtos.view.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

@Data
public class ApiErrors {
    private HttpStatus httpStatus;
    private List<String> errors;

    public ApiErrors(HttpStatus httpStatus, List<String> errors) {
        this.httpStatus = httpStatus;
        this.errors = errors;
    }

    public ApiErrors(HttpStatus httpStatus, String error) {
        this.httpStatus = httpStatus;
        this.errors = Collections.singletonList(error);
    }
}
