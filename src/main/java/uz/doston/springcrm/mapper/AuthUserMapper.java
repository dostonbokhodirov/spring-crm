package uz.doston.springcrm.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.doston.springcrm.dto.auth.AuthUserDto;
import uz.doston.springcrm.entity.auth.AuthUser;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface AuthUserMapper extends BaseMapper {

    AuthUserDto toDto(AuthUser authUser);

    List<AuthUserDto> toDto(List<AuthUser> authUsers);

}
