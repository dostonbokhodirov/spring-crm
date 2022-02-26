package uz.doston.springcrm.mapper.project;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import uz.doston.springcrm.dto.organization.OrganizationCreateDto;
import uz.doston.springcrm.dto.organization.OrganizationDto;
import uz.doston.springcrm.dto.organization.OrganizationUpdateDto;
import uz.doston.springcrm.dto.project.ProjectCreateDto;
import uz.doston.springcrm.dto.project.ProjectDto;
import uz.doston.springcrm.dto.project.ProjectUpdateDto;
import uz.doston.springcrm.entity.organization.Organization;
import uz.doston.springcrm.entity.project.Project;
import uz.doston.springcrm.mapper.BaseMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ProjectMapper extends BaseMapper {

    ProjectDto toDto(Project project);

    List<ProjectDto> toDto(List<Project> projects);

    Project fromCreateDto(ProjectCreateDto projectCreateDto);

    Project fromUpdateDto(ProjectUpdateDto projectUpdateDto);

}
