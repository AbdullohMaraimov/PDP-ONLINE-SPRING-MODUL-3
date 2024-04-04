package com.app.car.project;

import lombok.*;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Project {
    private String id;
    private String name;
    private Path documentPath;
    private List<ProjectColumn> projectColumns;
    private LocalDateTime createdAt;
}
