package com.app.inclass.project;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.nio.file.Path;

@Mapper(
        uses = {ProjectColumnMapper.class}
)
public interface ProjectMapper {
    ProjectMapper PROJECT_MAPPER = Mappers.getMapper(ProjectMapper.class);
    @Mapping(source = "documentPath", target =  "documentPath", qualifiedByName = "pathToString")
    @Mapping(target = "createdAt", source = "createdAt", dateFormat = "dd.MM.YYYY")
    ProjectDto toDto(Project project);

    @Named("pathToString")
    default String pathToString(Path path) {
        if (path == null) {
            return null;
        }
        return path.toString();
    }
}
