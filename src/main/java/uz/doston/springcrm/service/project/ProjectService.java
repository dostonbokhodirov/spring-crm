package uz.doston.springcrm.service.project;

import org.springframework.stereotype.Service;
import uz.doston.springcrm.dto.project.ProjectCreateDto;
import uz.doston.springcrm.dto.project.ProjectUpdateDto;
import uz.doston.springcrm.entity.project.Project;
import uz.doston.springcrm.entity.task.Task;
import uz.doston.springcrm.mapper.ProjectMapper;
import uz.doston.springcrm.repository.ProjectRepository;
import uz.doston.springcrm.repository.task.TaskRepository;
import uz.doston.springcrm.service.base.AbstractService;
import uz.doston.springcrm.service.base.GenericCrudService;

import java.util.List;

@Service
public class ProjectService extends AbstractService<ProjectMapper, ProjectRepository>
        implements GenericCrudService<ProjectCreateDto, ProjectUpdateDto> {

    private TaskRepository taskRepository;

    public ProjectService(ProjectMapper mapper, ProjectRepository repository) {
        super(mapper, repository);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void create(ProjectCreateDto projectCreateDto) {
        Project project = mapper.fromCreateDto(projectCreateDto);
        repository.save(project);
    }

    @Override
    public void update(ProjectUpdateDto projectUpdateDto) {
        Project project = mapper.fromUpdateDto(projectUpdateDto);
        repository.save(project);
    }


    public List<Task> getAllTasks(Long id) {
       return taskRepository.findAllByProjectId(id);
    }


//    @Override
//    public List<ProjectDto> getAll() {
//        List<Project> projects = repository.findAll();
//        return mapper.toDto(projects);
//    }
//
//    @Override
//    public ProjectDto get(Long id) {
//        Project project = repository.findById(id).orElseThrow(() -> new RuntimeException("Project Not Found"));
//        return mapper.toDto(project);
//    }
}
