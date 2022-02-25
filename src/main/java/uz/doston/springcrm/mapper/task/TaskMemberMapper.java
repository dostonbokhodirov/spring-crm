package uz.doston.springcrm.mapper.task;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.doston.springcrm.dto.task.TaskMemberDto;
import uz.doston.springcrm.entity.task.TaskMember;
import uz.doston.springcrm.mapper.BaseMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface TaskMemberMapper extends BaseMapper {


    List<TaskMemberDto> toDto(List<TaskMember> members );


}
