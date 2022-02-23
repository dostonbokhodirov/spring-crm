package uz.doston.springcrm.service.organization;

import org.springframework.stereotype.Service;
import uz.doston.springcrm.dto.organization.OrganizationCreateDto;
import uz.doston.springcrm.dto.organization.OrganizationDto;
import uz.doston.springcrm.dto.organization.OrganizationUpdateDto;
import uz.doston.springcrm.entity.organization.Organization;
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

    public OrganizationService(/*@Qualifier(value = "organizationMapper") */OrganizationMapper mapper, OrganizationRepository repository) {
        super(mapper, repository);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void create(OrganizationCreateDto organizationCreateDto) {
        Organization organization = mapper.fromCreateDto(organizationCreateDto);
        repository.save(organization);
    }

    @Override
    public void update(OrganizationUpdateDto organizationUpdateDto) {
//        Organization organization = mapper.fromUpdateDto(organizationUpdateDto);
//        repository.save(organization);

        repository.update(organizationUpdateDto);
    }

    @Override
    public List<OrganizationDto> getAll() {
        List<Organization> organizations = repository.findAll();
        return mapper.toDto(organizations);
    }

    @Override
    public OrganizationDto get(Long id) {
        Organization organization = repository.findById(id).orElseThrow(() -> new RuntimeException("Organization not found"));
        return mapper.toDto(organization);
    }

}
