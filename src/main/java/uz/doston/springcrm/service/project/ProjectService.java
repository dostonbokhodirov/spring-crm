package uz.doston.springcrm.service.project;

import org.springframework.stereotype.Service;
import uz.doston.springcrm.dto.column.ProjectColumnCreateDto;
import uz.doston.springcrm.dto.column.ProjectColumnDto;
import uz.doston.springcrm.dto.column.ProjectColumnUpdateDto;
import uz.doston.springcrm.dto.project.ProjectCreateDto;
import uz.doston.springcrm.dto.project.ProjectDto;
import uz.doston.springcrm.dto.project.ProjectUpdateDto;
import uz.doston.springcrm.entity.project.Project;
import uz.doston.springcrm.entity.project.ProjectColumn;
import uz.doston.springcrm.entity.project.ProjectMember;
import uz.doston.springcrm.mapper.project.ProjectColumnMapper;
import uz.doston.springcrm.mapper.project.ProjectMapper;
import uz.doston.springcrm.mapper.task.TaskMapper;
import uz.doston.springcrm.repository.column.ProjectColumnRepository;
import uz.doston.springcrm.repository.project.ProjectMemberRepository;
import uz.doston.springcrm.repository.project.ProjectRepository;
import uz.doston.springcrm.service.base.AbstractService;
import uz.doston.springcrm.service.base.GenericCrudService;
import uz.doston.springcrm.service.base.GenericService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProjectService extends AbstractService<ProjectMapper, ProjectRepository>
        implements GenericCrudService<ProjectCreateDto, ProjectUpdateDto>, GenericService<ProjectDto> {


    private ProjectColumnRepository columnRepository;
    private ProjectColumnMapper columnMapper;
    private final TaskMapper taskMapper;

    private ProjectMemberRepository projectMemberRepository;

    public ProjectService(ProjectMapper mapper,
                          ProjectRepository repository,
                          ProjectColumnRepository columnRepository,
                          ProjectColumnMapper columnMapper,
                          TaskMapper taskMapper, ProjectMemberRepository projectMemberRepository) {
        super(mapper, repository);

        this.columnRepository = columnRepository;
        this.columnMapper = columnMapper;
        this.taskMapper = taskMapper;
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

    public Long getMembersId(Long id) {
        List<ProjectMember> projectMembers = projectMemberRepository.findProjectMembersByProjectId(id);
        return (long) projectMembers.size();
    }


    @Transactional
    public List<ProjectColumnDto> getAllColumns(Long id) {

        List<ProjectColumn> columns = columnRepository.findProjectColumnsByProjectId(id);
        List<ProjectColumnDto> dtoList = columnMapper.toDto(columns);
//        for (ProjectColumnDto dto : dtoList) {
//            for (ProjectColumn column : columns) {
//                dto.setTasks(column.getTasks());
//                dto.setTasks(taskMapper.toDto(column.getTasks()));
//            }
//        }
        return dtoList;
    }


    public List<ProjectColumn> getAllColumnEntity(Long id) {
        return columnRepository.findProjectColumnsByProjectId(id);
    }

    @Transactional
    public List<ProjectColumn> getAllColumnsBy(Long id) {
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


    public void createColumn(Long id, ProjectColumnCreateDto dto){
        ProjectColumn projectColumn = columnMapper.fromCreateDto(dto);
        projectColumn.setProjectId(id);
        columnRepository.save(projectColumn);
    }


    public ProjectColumnDto getColumn(Long columnId){
        ProjectColumn projectColumn = columnRepository.findById(columnId).get();
        return columnMapper.toDto(projectColumn);
    }

    public void deleteColumn(Long columnId){
        columnRepository.deleteById(columnId);
    }


    public void updateColumn(ProjectColumnUpdateDto dto){

        ProjectColumn projectColumn = columnMapper.fromUpdateDto(dto);
        columnRepository.update(projectColumn);
    }



}
