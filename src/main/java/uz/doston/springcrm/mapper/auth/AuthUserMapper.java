package uz.doston.springcrm.mapper.auth;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import uz.doston.springcrm.dto.auth.AuthUserCreateDto;
import uz.doston.springcrm.entity.auth.AuthUser;
import uz.doston.springcrm.dto.auth.AuthUserDto;
import uz.doston.springcrm.entity.auth.AuthUser;
import uz.doston.springcrm.mapper.BaseMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface AuthUserMapper extends BaseMapper {

    AuthUserDto toDto(AuthUser authUser);

    List<AuthUserDto> toDto(List<AuthUser> authUsers);


    @Mapping(target = "role", ignore = true)
    AuthUser fromCreateDto(AuthUserCreateDto dto);
}
