package com.app.car.project;

import lombok.*;

import java.time.LocalDateTime;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ProjectColumn {
    private String id;
    private String name;
    private Integer order;
    private LocalDateTime createdAt;
}
