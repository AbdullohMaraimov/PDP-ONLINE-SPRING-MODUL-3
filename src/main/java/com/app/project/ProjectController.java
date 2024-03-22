package com.app.project;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectController(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @GetMapping
    public List<ProjectDTO> getAllProject() {
        List<Project> projects = projectRepository.findAll();
        List<ProjectDTO> projectDTOS = projectMapper.toDto(projects);
        return projectDTOS;
    }

    @PostMapping
    public Project projectCreateDto(@RequestBody ProjectCreateDto dto) {
        Project project = projectMapper.fromCreateDTO(dto);
        project.setCode(dto.getName());
        project.setName(dto.getName().replace(" ", "_").toUpperCase());
        projectRepository.save(project);
        return project;
    }

}
