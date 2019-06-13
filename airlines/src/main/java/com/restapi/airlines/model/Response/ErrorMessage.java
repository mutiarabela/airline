package com.restapi.airlines.model.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Setter
@Getter
public class ErrorMessage {
    private String message;
    private String[] errors;
}
