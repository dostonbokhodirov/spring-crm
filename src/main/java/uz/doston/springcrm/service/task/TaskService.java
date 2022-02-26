package uz.doston.springcrm.service.task;

import org.springframework.stereotype.Service;
import uz.doston.springcrm.dto.task.TaskCreateDto;
import uz.doston.springcrm.dto.task.TaskDto;
import uz.doston.springcrm.dto.task.TaskUpdateDto;
import uz.doston.springcrm.entity.task.Task;
import uz.doston.springcrm.mapper.task.TaskMapper;
import uz.doston.springcrm.repository.task.TaskRepository;
import uz.doston.springcrm.service.base.AbstractService;
import uz.doston.springcrm.service.base.GenericCrudService;
import uz.doston.springcrm.service.base.GenericService;

import java.io.IOException;
import java.util.List;

@Service
public class TaskService extends AbstractService<TaskMapper, TaskRepository> implements GenericCrudService<TaskCreateDto, TaskUpdateDto>, GenericService<TaskDto> {
    public TaskService(TaskMapper mapper, TaskRepository repository) {
        super(mapper, repository);
    }


    public List<TaskDto> getAllTasks(Long id) {
        List<Task> tasks = repository.findAllByProjectId(id);
        return mapper.toDto(tasks);
    }


    @Override
    public void delete(Long id) {

    }

    @Override
    public void create(TaskCreateDto taskCreateDto) {

    }

    @Override
    public void update(TaskUpdateDto taskUpdateDto) throws IOException {

    }

    @Override
    public List<TaskDto> getAll() {
        return null;
    }

    @Override
    public TaskDto get(Long id) {
        return null;
    }
}
