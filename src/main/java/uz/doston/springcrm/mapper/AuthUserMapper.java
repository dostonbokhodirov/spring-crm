package uz.doston.springcrm.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import uz.doston.springcrm.dto.auth.AuthUserCreateDto;
import uz.doston.springcrm.entity.auth.AuthUser;

@Component
@Mapper(componentModel = "spring")
public interface AuthUserMapper extends BaseMapper {

    @Mapping(target = "role", ignore = true)
    AuthUser fromCreateDto(AuthUserCreateDto dto);
}
