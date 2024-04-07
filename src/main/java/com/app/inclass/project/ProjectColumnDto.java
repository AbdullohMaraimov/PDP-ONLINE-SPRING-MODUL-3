package com.app.inclass.project;

import lombok.*;

import java.time.LocalDateTime;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ProjectColumnDto {
    private String pc_name;
    private String pc_order;
    private LocalDateTime pc_createdAt;
}
