package uz.doston.springcrm.service.organization;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import uz.doston.springcrm.dto.organization.OrganizationCreateDto;
import uz.doston.springcrm.dto.organization.OrganizationDto;
import uz.doston.springcrm.dto.organization.OrganizationUpdateDto;
import uz.doston.springcrm.entity.organization.Logo;
import uz.doston.springcrm.entity.organization.Organization;
import uz.doston.springcrm.mapper.organization.OrganizationMapper;
import uz.doston.springcrm.repository.organization.OrganizationRepository;
import uz.doston.springcrm.service.base.AbstractService;
import uz.doston.springcrm.service.base.GenericCrudService;
import uz.doston.springcrm.service.base.GenericService;

import java.util.List;

@Service(value = "organizationService")
public class OrganizationService extends AbstractService<OrganizationMapper, OrganizationRepository>
        implements GenericCrudService<OrganizationCreateDto, OrganizationUpdateDto>,
        GenericService<OrganizationDto> {

    private final OrganizationLogoService logoService;
    public OrganizationService(OrganizationMapper mapper, OrganizationRepository repository, OrganizationLogoService logoService) {
        super(mapper, repository);
        this.logoService = logoService;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    @SneakyThrows
    public void create(OrganizationCreateDto dto) {
        Logo logo = logoService.create(dto.getLogo());
        Organization organization = mapper.fromCreateDto(dto);
        organization.setLogo(logo);
        repository.save(organization);
    }

    @Override
    public void update(OrganizationUpdateDto organizationUpdateDto) {

    }


    @Override
    public List<OrganizationDto> getAll() {
        List<Organization> organizations = repository.findAll();
        return mapper.toDto(organizations);
    }

    @Override
    public OrganizationDto get(Long id) {
        return null;
    }

}
