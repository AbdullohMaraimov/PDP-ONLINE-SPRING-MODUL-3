package com.app.project;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProjectMapper {
    Project toEntity(ProjectDTO projectDTO);

    ProjectDTO toDto(Project project);

    List<ProjectDTO> toDto(List<Project> project);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Project partialUpdate(ProjectDTO projectDTO, @MappingTarget Project project);

    Project fromCreateDTO(ProjectCreateDto projectCreateDto);

    ProjectCreateDto toDto1(Project project);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Project partialUpdate(ProjectCreateDto projectCreateDto, @MappingTarget Project project);
}