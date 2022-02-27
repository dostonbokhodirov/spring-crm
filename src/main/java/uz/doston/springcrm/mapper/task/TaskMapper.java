package uz.doston.springcrm.mapper.task;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.doston.springcrm.dto.column.ProjectColumnDto;
import uz.doston.springcrm.dto.task.TaskCreateDto;
import uz.doston.springcrm.dto.task.TaskDto;
import uz.doston.springcrm.dto.task.TaskUpdateDto;
import uz.doston.springcrm.entity.project.ProjectColumn;
import uz.doston.springcrm.entity.task.Task;
import uz.doston.springcrm.mapper.BaseMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface TaskMapper extends BaseMapper {

    TaskDto toDto(Task task);

    List<TaskDto> toDto(List<Task> tasks);

    Task fromCreateDto(TaskCreateDto taskCreateDto);

    Task fromUpdateDto(TaskUpdateDto taskUpdateDto);
}
