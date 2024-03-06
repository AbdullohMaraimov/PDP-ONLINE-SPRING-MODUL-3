package com.app.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BookDto {
    private String title;
    private String author;
    private int price;
    private String description;
}
