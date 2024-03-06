package com.app.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Book {
    private Long id;
    private String title;
    private String author;
    private int price;
    private String description;
}
