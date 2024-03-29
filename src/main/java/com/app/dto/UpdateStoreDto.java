package com.app.dto;

import lombok.Data;

@Data
public class UpdateStoreDto {
    private Integer id;
    private String name;
    private String email;
    private String description;
}
