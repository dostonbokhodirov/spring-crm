package uz.doston.springcrm.service.project;

import org.springframework.stereotype.Service;
import uz.doston.springcrm.dto.column.ProjectColumnDto;
import uz.doston.springcrm.entity.project.ProjectColumn;
import uz.doston.springcrm.mapper.project.ProjectColumnMapper;
import uz.doston.springcrm.repository.column.ProjectColumnRepository;
import uz.doston.springcrm.service.base.AbstractService;
import uz.doston.springcrm.service.base.GenericService;

import java.util.List;

@Service
public class ProjectColumnService extends AbstractService<ProjectColumnMapper, ProjectColumnRepository>
        implements GenericService<ProjectColumnDto> {

    public ProjectColumnService(ProjectColumnMapper mapper, ProjectColumnRepository repository) {
        super(mapper, repository);
    }

    public List<ProjectColumnDto> getAllColumns(Long id) {
        List<ProjectColumn> columns = repository.findProjectColumnsByProjectId(id);
        return mapper.toDto(columns);
    }

    @Override
    public List<ProjectColumnDto> getAll() {
        return null;
    }

    @Override
    public ProjectColumnDto get(Long id) {
        ProjectColumn projectColumn = repository.findById(id).orElseThrow(() -> new RuntimeException("Column Not Found"));
        return mapper.toDto(projectColumn);
    }
}
