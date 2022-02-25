package uz.doston.springcrm.service.project;

import org.springframework.stereotype.Service;
import uz.doston.springcrm.dto.auth.AuthUserDto;
import uz.doston.springcrm.dto.column.ProjectColumnDto;
import uz.doston.springcrm.dto.project.ProjectCreateDto;
import uz.doston.springcrm.dto.project.ProjectDto;
import uz.doston.springcrm.dto.project.ProjectUpdateDto;
import uz.doston.springcrm.dto.task.TaskDto;
import uz.doston.springcrm.entity.project.Project;
import uz.doston.springcrm.entity.project.ProjectColumn;
import uz.doston.springcrm.entity.task.Task;
import uz.doston.springcrm.entity.task.TaskMember;
import uz.doston.springcrm.mapper.AuthUserMapper;
import uz.doston.springcrm.mapper.ProjectColumnMapper;
import uz.doston.springcrm.mapper.ProjectMapper;
import uz.doston.springcrm.mapper.task.TaskMapper;
import uz.doston.springcrm.mapper.task.TaskMemberMapper;
import uz.doston.springcrm.repository.project.ProjectMemberRepository;
import uz.doston.springcrm.repository.project.ProjectRepository;
import uz.doston.springcrm.repository.auth.AuthUserRepository;
import uz.doston.springcrm.repository.column.ProjectColumnRepository;
import uz.doston.springcrm.repository.task.TaskMemberRepository;
import uz.doston.springcrm.repository.task.TaskRepository;
import uz.doston.springcrm.service.base.AbstractService;
import uz.doston.springcrm.service.base.GenericCrudService;
import uz.doston.springcrm.service.base.GenericService;

import javax.swing.event.ListSelectionEvent;
import java.util.List;
import java.util.Objects;

@Service
public class ProjectService extends AbstractService<ProjectMapper, ProjectRepository>
        implements GenericCrudService<ProjectCreateDto, ProjectUpdateDto>, GenericService<ProjectDto> {

    private TaskRepository taskRepository;
    private TaskMapper taskMapper;

    private ProjectColumnRepository columnRepository;
    private ProjectColumnMapper columnMapper;

    private TaskMemberRepository taskMemberRepository;
    private TaskMemberMapper taskMemberMapper;

    private AuthUserRepository userRepository;
    private AuthUserMapper userMapper;


    private ProjectMemberRepository projectMemberRepository;


    public ProjectService(ProjectMapper mapper,
                          ProjectRepository repository,
                          ProjectMemberRepository projectMemberRepository,
                          TaskRepository taskRepository,
                          ProjectColumnRepository columnRepository,
                          ProjectColumnMapper columnMapper,
                          TaskMapper taskMapper,
                          TaskMemberRepository taskMemberRepository,
                          TaskMemberMapper taskMemberMapper,
                          AuthUserRepository userRepository,
                          AuthUserMapper userMapper) {
        super(mapper, repository);
        this.projectMemberRepository = projectMemberRepository;
        this.taskRepository = taskRepository;
        this.columnRepository = columnRepository;
        this.columnMapper = columnMapper;
        this.taskMapper = taskMapper;
        this.taskMemberRepository = taskMemberRepository;
        this.taskMemberMapper = taskMemberMapper;

        this.userRepository = userRepository;
        this.userMapper = userMapper;
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


//    public List<Task> getAllTasks(Long id) {
//       return taskRepository.findAllByProjectId(id);
//    }


    public List<Long> getMembersId(Long id) {
        return projectMemberRepository.findProjectMembersByProjectId(id);
    }


    public List<ProjectColumnDto> getAllColumns(Long id, List<AuthUserDto> userDtos) {
        List<ProjectColumn> columns = columnRepository.findProjectColumnsByProjectId(id);
        List<ProjectColumnDto> columnDtos = columnMapper.toDto(columns);



        List<Long> taskMembersId = taskMemberRepository.findAllByProjectColumnId()

        List<Task> tasks = taskRepository.findAllByProjectId(id);
        List<TaskDto> taskDtos = taskMapper.toDto(tasks);


//        taskMemberRepository.fi

        for (TaskDto taskDto : taskDtos) {


//            for (AuthUserDto userDto : userDtos) {
//                if ()
//            }

        }

//        List<TaskMember> members =


        for (ProjectColumnDto projectColumnDto : columnDtos) {
            for (TaskDto taskDto : taskDtos) {
                if (taskDto.getColumnId().equals(projectColumnDto.getId())) {
                    if (Objects.isNull(projectColumnDto.getTasks())) {
                        projectColumnDto.setTasks(List.of(taskDto));
                    } else {
                        projectColumnDto.getTasks().add(taskDto);
                    }
                }
            }
        }


        List<TaskMember> members = taskMemberRepository.
        return columnMapper.toDto(columns);
    }


    @Override
    public List<ProjectDto> getAll() {
        List<Project> projects = repository.findAll();
        return mapper.toDto(projects);
    }

    @Override
    public ProjectDto get(Long id) {
        Project project = repository.findById(id).orElseThrow(() -> new RuntimeException("Project Not Found"));
        return mapper.toDto(project);
    }
}
