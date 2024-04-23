package com.genesis.demo.models.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Builder
@Data
public class ErrorResponse {
    private LocalDate date;
    private String message;
    private String statusCode;
}
