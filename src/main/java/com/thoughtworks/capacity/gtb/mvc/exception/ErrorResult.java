package com.thoughtworks.capacity.gtb.mvc.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ErrorResult {
    private int code;
    private String message;
}
