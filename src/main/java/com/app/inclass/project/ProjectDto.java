package com.app.inclass.project;

import lombok.*;

import java.util.List;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ProjectDto {
    private String id;
    private String name;
    private String documentPath;
    private List<ProjectColumnDto> projectColumns;
    private String createdAt;
}
