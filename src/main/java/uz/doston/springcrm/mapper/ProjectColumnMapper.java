package uz.doston.springcrm.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import uz.doston.springcrm.dto.column.ProjectColumnDto;
import uz.doston.springcrm.entity.project.ProjectColumn;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ProjectColumnMapper extends BaseMapper{

    @Mapping(target = "tasks",ignore = true)
    ProjectColumnDto toDto(ProjectColumn projectColumn);


    @Mapping(target = "tasks",ignore = true)
    List<ProjectColumnDto> toDto(List<ProjectColumn> projectColumns);

}
