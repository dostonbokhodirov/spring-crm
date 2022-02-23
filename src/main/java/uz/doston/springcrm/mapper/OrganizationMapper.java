package uz.doston.springcrm.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.doston.springcrm.dto.organization.OrganizationDto;
import uz.doston.springcrm.entity.organization.Organization;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface OrganizationMapper extends BaseMapper {

    OrganizationDto toDto(Organization organization);

    List<OrganizationDto> toDto(List<Organization> list);
}
