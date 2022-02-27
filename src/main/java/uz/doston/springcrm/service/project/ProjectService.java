package uz.doston.springcrm.service.project;

import org.springframework.stereotype.Service;
import uz.doston.springcrm.dto.column.ProjectColumnDto;
import uz.doston.springcrm.dto.project.ProjectCreateDto;
import uz.doston.springcrm.dto.project.ProjectDto;
import uz.doston.springcrm.dto.project.ProjectUpdateDto;
import uz.doston.springcrm.dto.task.TaskDto;
import uz.doston.springcrm.entity.project.Project;
import uz.doston.springcrm.entity.project.ProjectColumn;
import uz.doston.springcrm.entity.project.ProjectMember;
import uz.doston.springcrm.entity.task.Task;
import uz.doston.springcrm.mapper.project.ProjectColumnMapper;
import uz.doston.springcrm.mapper.project.ProjectMapper;
import uz.doston.springcrm.repository.column.ProjectColumnRepository;
import uz.doston.springcrm.repository.project.ProjectMemberRepository;
import uz.doston.springcrm.repository.project.ProjectRepository;
import uz.doston.springcrm.service.base.AbstractService;
import uz.doston.springcrm.service.base.GenericCrudService;
import uz.doston.springcrm.service.base.GenericService;

import java.util.List;
import java.util.Objects;

@Service
public class ProjectService extends AbstractService<ProjectMapper, ProjectRepository>
        implements GenericCrudService<ProjectCreateDto, ProjectUpdateDto>, GenericService<ProjectDto> {


    private ProjectColumnRepository columnRepository;
    private ProjectColumnMapper columnMapper;

    private ProjectMemberRepository projectMemberRepository;

    public ProjectService(ProjectMapper mapper,
                          ProjectRepository repository,
                          ProjectColumnRepository columnRepository,
                          ProjectColumnMapper columnMapper,
                          ProjectMemberRepository projectMemberRepository) {
        super(mapper, repository);

        this.columnRepository = columnRepository;
        this.columnMapper = columnMapper;
        this.projectMemberRepository = projectMemberRepository;
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


    public Long getMembersId(Long id) {
        List<ProjectMember> projectMembers = projectMemberRepository.findProjectMembersByProjectId(id);
        return (long) projectMembers.size();
    }


    public List<ProjectColumnDto> getAllColumns(Long id, List<Task> taskDtos) {

        List<ProjectColumn> columns = columnRepository.findProjectColumnsByProjectId(id);
        List<ProjectColumnDto> columnDtos = columnMapper.toDto(columns);

//        for (ProjectColumnDto columnDto : columnDtos) {
//            for (Task taskDto : taskDtos) {
//                if (taskDto.getColumnId().equals(columnDto.getId())) {
//                    if (Objects.isNull(columnDto.getTasks())) {
//                        columnDto.setTasks(List.of(taskDto));
//                    } else {
//                        columnDto.getTasks().add(taskDto);
//                    }
//                }
//            }
//        }
        return columnDtos;
    }


    public List<ProjectColumn> getAllColumnEntity(Long id){
        return columnRepository.findProjectColumnsByProjectId(id);
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
