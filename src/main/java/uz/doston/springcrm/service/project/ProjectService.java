package uz.doston.springcrm.service.project;

import org.springframework.stereotype.Service;
import uz.doston.springcrm.dto.column.ProjectColumnDto;
import uz.doston.springcrm.dto.project.ProjectCreateDto;
import uz.doston.springcrm.dto.project.ProjectDto;
import uz.doston.springcrm.dto.project.ProjectUpdateDto;
import uz.doston.springcrm.entity.project.Project;
import uz.doston.springcrm.entity.project.ProjectColumn;
import uz.doston.springcrm.mapper.project.ProjectColumnMapper;
import uz.doston.springcrm.mapper.project.ProjectMapper;
import uz.doston.springcrm.repository.column.ProjectColumnRepository;
import uz.doston.springcrm.repository.project.ProjectRepository;
import uz.doston.springcrm.service.base.AbstractService;
import uz.doston.springcrm.service.base.GenericCrudService;
import uz.doston.springcrm.service.base.GenericService;

import java.util.List;

@Service
public class ProjectService extends AbstractService<ProjectMapper, ProjectRepository>
        implements GenericCrudService<ProjectCreateDto, ProjectUpdateDto>, GenericService<ProjectDto> {



    private ProjectColumnRepository columnRepository;
    private ProjectColumnMapper columnMapper;

    public ProjectService(ProjectMapper mapper,
                          ProjectRepository repository,
                          ProjectColumnRepository columnRepository,
                          ProjectColumnMapper columnMapper) {
        super(mapper, repository);

        this.columnRepository = columnRepository;
        this.columnMapper = columnMapper;

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


//    public List<Long> getMembersId(Long id) {
//        return projectMemberRepository.findProjectMembersByProjectId(id);
//    }


    public List<ProjectColumnDto> getAllColumns(Long id) {

        List<ProjectColumn> columns = columnRepository.findProjectColumnsByProjectId(id);
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
