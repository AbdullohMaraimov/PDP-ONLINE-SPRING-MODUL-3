package com.app;

import lombok.*;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ErrorDTO {
    private String errorPath;
    private int errorCode;
    private Map<String, String> errorBody;
}
