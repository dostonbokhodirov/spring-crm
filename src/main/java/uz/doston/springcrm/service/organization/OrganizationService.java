package uz.doston.springcrm.service.organization;

import org.springframework.stereotype.Service;
import uz.doston.springcrm.repository.organization.OrganizationRepository;
import uz.doston.springcrm.service.AbstractService;
import uz.doston.springcrm.service.GenericCrudService;
import uz.doston.springcrm.service.GenericService;

@Service
public class OrganizationService extends AbstractService<OrganizationMapper, OrganizationRepository>
        implements GenericCrudService<OrganizationCreateDto, OrganizationUpdateDto>,
        GenericService<OrganizationDto> {
}
