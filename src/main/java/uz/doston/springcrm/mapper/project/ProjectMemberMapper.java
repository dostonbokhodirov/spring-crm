package uz.doston.springcrm.mapper.project;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.doston.springcrm.dto.project.member.ProjectMemberDto;
import uz.doston.springcrm.entity.project.ProjectMember;
import uz.doston.springcrm.mapper.BaseMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ProjectMemberMapper extends BaseMapper {


    List<ProjectMemberDto> toDto(List<ProjectMember> projectMembers);
}
