package uz.doston.springcrm.mapper.organization;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;
import uz.doston.springcrm.dto.organization.OrganizationCreateDto;
import uz.doston.springcrm.dto.organization.OrganizationDto;
import uz.doston.springcrm.dto.organization.OrganizationUpdateDto;
import uz.doston.springcrm.entity.organization.Organization;
import uz.doston.springcrm.mapper.BaseMapper;

import java.util.List;

@Component(value = "organizationMapper")
@Mapper(componentModel = "spring")
public interface OrganizationMapper extends BaseMapper {

    OrganizationDto toDto(Organization organization);

    List<OrganizationDto> toDto(List<Organization> list);

    Organization findByCode(String code);

    @Mapping(target = "logo", ignore = true)
    Organization fromCreateDto(OrganizationCreateDto organizationCreateDto);

    @Mapping(target = "logo", ignore = true)
    Organization fromUpdateDto(OrganizationUpdateDto organizationUpdateDto, @MappingTarget Organization organization);

}
