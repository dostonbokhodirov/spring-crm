package uz.doston.springcrm.service.project;

import org.springframework.stereotype.Service;
import uz.doston.springcrm.dto.auth.AuthUserDto;
import uz.doston.springcrm.dto.column.ProjectColumnDto;
import uz.doston.springcrm.dto.project.ProjectCreateDto;
import uz.doston.springcrm.dto.project.ProjectDto;
import uz.doston.springcrm.dto.project.ProjectUpdateDto;
import uz.doston.springcrm.dto.task.TaskDto;
import uz.doston.springcrm.dto.task.TaskMemberDto;
import uz.doston.springcrm.entity.project.Project;
import uz.doston.springcrm.entity.task.TaskMember;
import uz.doston.springcrm.mapper.project.ProjectMapper;
import uz.doston.springcrm.mapper.project.ProjectMemberMapper;
import uz.doston.springcrm.mapper.task.TaskMemberMapper;
import uz.doston.springcrm.repository.project.ProjectMemberRepository;
import uz.doston.springcrm.repository.project.ProjectRepository;
import uz.doston.springcrm.repository.task.TaskMemberRepository;
import uz.doston.springcrm.service.base.AbstractService;
import uz.doston.springcrm.service.base.GenericCrudService;
import uz.doston.springcrm.service.base.GenericService;

import java.util.List;
import java.util.Objects;

@Service
public class ProjectService extends AbstractService<ProjectMapper, ProjectRepository>
        implements GenericCrudService<ProjectCreateDto, ProjectUpdateDto>, GenericService<ProjectDto> {


    private TaskMemberRepository taskMemberRepository;
    private TaskMemberMapper taskMemberMapper;

    private ProjectMemberRepository projectMemberRepository;
    private ProjectMemberMapper projectMemberMapper;


    public ProjectService(ProjectMapper mapper,
                          ProjectRepository repository,
                          ProjectMemberRepository projectMemberRepository,
                          TaskMemberRepository taskMemberRepository,
                          TaskMemberMapper taskMemberMapper) {
        super(mapper, repository);
        this.projectMemberRepository = projectMemberRepository;
        this.taskMemberRepository = taskMemberRepository;
        this.taskMemberMapper = taskMemberMapper;
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


    public List<ProjectColumnDto> getAllColumns(Long id, List<AuthUserDto> userDtos, List<TaskDto> taskDtos, List<ProjectColumnDto> columnDtos) {

        for (ProjectColumnDto columnDto : columnDtos) {
            List<TaskMember> taskMembersId = taskMemberRepository.findAllByProjectColumnId(columnDto.getId());
            List<TaskMemberDto> taskMemberDtos = taskMemberMapper.toDto(taskMembersId);

            for (TaskMemberDto taskMember : taskMemberDtos) {
                for (AuthUserDto userDto : userDtos) {
                    for (TaskDto taskDto : taskDtos) {
                        if (taskMember.getUserId().equals(userDto.getId()) && taskDto.getId().equals(taskMember.getTaskId())) {
                            if (Objects.isNull(taskDto.getUsers())){
                                taskDto.setUsers(List.of(userDto));
                            }
                            else {
                                taskDto.getUsers().add(userDto);
                            }
                        }
                    }
                }
            }

        }


//        for (ProjectColumnDto columnDto : columnDtos) {
//            List<TaskMember> taskMembersId = taskMemberRepository.findAllByProjectColumnId(columnDto.getId());
//            List<TaskMemberDto> taskMemberDtos = taskMemberMapper.toDto(taskMembersId);
//
//
//
//            for (TaskMemberDto taskMemberDto : taskMemberDtos) {
//                for (ProjectMemberDto projectMemberDto : projectMemberDtos) {
//                    for (AuthUserDto userDto : userDtos) {
//                        if (taskMemberDto.getMemberId().equals(projectMemberDto.getId()) && projectMemberDto.getUserId().equals(userDto.getId())) {
//
//                            for (TaskDto taskDto : taskDtos) {
//                                if (Objects.isNull(taskDto.getUsers())) {
//                                    taskDto.setUsers(List.of(userDto));
//                                }
//                                else {
//                                    taskDto.getUsers().add(userDto);
//                                }
//                            }
//
//                        }
//                    }
//
//                }
//
//            }
//
//        }


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


        return columnDtos;
    }


    @Override
    public List<ProjectDto> getAll() {
        List<Project> projects = repository.findAll();
        List<ProjectDto> dtoList = mapper.toDto(projects);
        return dtoList;
    }

    @Override
    public ProjectDto get(Long id) {
        Project project = repository.findById(id).orElseThrow(() -> new RuntimeException("Project Not Found"));
        return mapper.toDto(project);
    }
}
