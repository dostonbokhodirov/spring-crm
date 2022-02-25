package uz.doston.springcrm.service.task;


import org.springframework.stereotype.Service;
import uz.doston.springcrm.dto.task.TaskDto;
import uz.doston.springcrm.entity.task.Task;
import uz.doston.springcrm.mapper.task.TaskMapper;
import uz.doston.springcrm.repository.task.TaskRepository;
import uz.doston.springcrm.service.base.AbstractService;
import uz.doston.springcrm.service.base.GenericService;

import java.util.List;

@Service
public class TaskService extends AbstractService<TaskMapper, TaskRepository>
        implements GenericService<TaskDto> {

    public TaskService(TaskMapper mapper, TaskRepository repository) {
        super(mapper, repository);
    }


    public List<TaskDto> getAllTasks(Long id) {
        List<Task> tasks = repository.findAllByProjectId(id);
        return mapper.toDto(tasks);
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
