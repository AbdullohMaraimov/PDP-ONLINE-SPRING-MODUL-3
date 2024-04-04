package com.app.car.project;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

import static com.app.car.project.ProjectMapper.PROJECT_MAPPER;
import static org.junit.jupiter.api.Assertions.*;

class ProjectMapperTest {

    @Test
    void toDto() {
        Project project = new Project("1", "TodoApp", Path.of("https://online.pdp.uz"), null, null);
        ProjectDto projectDto = PROJECT_MAPPER.toDto(project);
        System.out.println(projectDto);
    }

    @Test
    void toDtoWithProjecTcolumn() {
        List<ProjectColumn> projectColumns = List.of(
                new ProjectColumn("1", "Todo", 1, LocalDateTime.now()),
                new ProjectColumn("2", "Doing", 2, LocalDateTime.now()),
                new ProjectColumn("3", "Done", 3, LocalDateTime.now()),
                new ProjectColumn("4", "QA", 4, LocalDateTime.now())
        );
        Project project = new Project("1", "New Java Backend", Path.of("https://online.pdp.uz/java-backend.pdf"),
                projectColumns,
                LocalDateTime.now());
        ProjectDto dto = PROJECT_MAPPER.toDto(project);
        System.out.println("dto = " + dto);
}}