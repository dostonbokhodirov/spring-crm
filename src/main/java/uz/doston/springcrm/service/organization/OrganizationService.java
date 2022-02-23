package uz.doston.springcrm.service.organization;

import org.springframework.stereotype.Service;
import uz.doston.springcrm.dto.organization.OrganizationCreateDto;
import uz.doston.springcrm.dto.organization.OrganizationDto;
import uz.doston.springcrm.dto.organization.OrganizationUpdateDto;
import uz.doston.springcrm.mapper.OrganizationMapper;
import uz.doston.springcrm.repository.organization.OrganizationRepository;
import uz.doston.springcrm.service.base.AbstractService;
import uz.doston.springcrm.service.base.GenericCrudService;
import uz.doston.springcrm.service.base.GenericService;

import java.util.List;

@Service
public class OrganizationService extends AbstractService<OrganizationMapper, OrganizationRepository>
        implements GenericCrudService<OrganizationCreateDto, OrganizationUpdateDto>,
        GenericService<OrganizationDto> {

    public OrganizationService(OrganizationMapper mapper, OrganizationRepository repository) {
        super(mapper, repository);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void create(OrganizationCreateDto organizationCreateDto) {

    }

    @Override
    public void update(OrganizationUpdateDto organizationUpdateDto) {

    }

    @Override
    public List<OrganizationDto> getAll() {
        return null;
    }

    @Override
    public OrganizationDto get(Long id) {
        return null;
    }
}
