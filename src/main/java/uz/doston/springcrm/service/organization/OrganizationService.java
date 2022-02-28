package uz.doston.springcrm.service.organization;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Qualifier;
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

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static uz.doston.springcrm.service.organization.OrganizationLogoService.UPLOAD_DIRECTORY;

@Service(value = "organizationService")
public class OrganizationService extends AbstractService<OrganizationMapper, OrganizationRepository>
        implements GenericCrudService<OrganizationCreateDto, OrganizationUpdateDto>,
        GenericService<OrganizationDto> {

    private final OrganizationLogoService logoService;

    public OrganizationService(@Qualifier("organizationMapperImpl") OrganizationMapper mapper, OrganizationRepository repository, OrganizationLogoService logoService) {
        super(mapper, repository);
        this.logoService = logoService;
    }

    public void delete(String code) {
        Organization organization = repository.findByCode(code);
        repository.deleteById(organization.getId());
    }

    @Override
    public void delete(Long id) {
    }

    @Transactional
    @Override
    @SneakyThrows
    public void create(OrganizationCreateDto dto) {
        Logo logo = logoService.create(dto.getLogo());
        Organization organization = mapper.fromCreateDto(dto);
        organization.setLogo(logo);
        organization.setOwnerId(1L);
        repository.save(organization);
    }

    @Override
    public void update(OrganizationUpdateDto dto) throws IOException {

        Organization organization = repository.findByCode(dto.getCode());
        mapper.fromUpdateDto(dto, organization);

        if (Objects.nonNull((dto.getLogo()))) {
            Logo logo = logoService.create(dto.getLogo());//TODO eski logoniyoqotish kerak filedan
            organization.setLogo(logo);
        }
        repository.save(organization);
    }

    @Override
    public List<OrganizationDto> getAll() {
        List<Organization> organizations = repository.findAll();
        List<OrganizationDto> organizationDtos = mapper.toDto(organizations);

        inputPathLogo(organizationDtos);
        return organizationDtos;
    }

    @Override
    public OrganizationDto get(Long id) {
        Optional<Organization> organization = repository.findById(id);
        OrganizationDto organizationDto = mapper.toDto(organization.get());
        Logo logo = organization.get().getLogo();
        organizationDto.setLogoPath(UPLOAD_DIRECTORY + "/" + logo.getGeneratedName() + "." + logo.getFormat());
        return organizationDto;
    }

    public OrganizationUpdateDto get(String code) {
        Organization organization = repository.findByCode(code);
        OrganizationUpdateDto organizationUpdateDto = new OrganizationUpdateDto();
        organizationUpdateDto.setId(organization.getId());
        organizationUpdateDto.setEmail(organization.getEmail());
        organizationUpdateDto.setCode(organization.getCode());
        organizationUpdateDto.setLocation(organization.getLocation());

        return organizationUpdateDto;
    }


    private void inputPathLogo(List<OrganizationDto> organizationDtos) {
        for (OrganizationDto organizationDto : organizationDtos) {
            organizationDto.setLogoPath(findLogoPathById(organizationDto.getLogo()));
        }
    }

    private String findLogoPathById(Logo logo) {
        return "../../logo/" + logo.getGeneratedName() + "." + logo.getFormat();
    }

}
