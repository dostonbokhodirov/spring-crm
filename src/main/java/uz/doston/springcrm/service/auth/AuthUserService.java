package uz.doston.springcrm.service.auth;

import uz.doston.springcrm.repository.auth.AuthUserRepository;
import uz.doston.springcrm.service.AbstractService;
import uz.doston.springcrm.service.GenericCrudService;
import uz.doston.springcrm.service.GenericService;

public class AuthUserService extends AbstractService<AuthUserMapper, AuthUserRepository>
        implements GenericCrudService<AuthUserCreateDto, AuthUserUpdateDto>, GenericService<AuthUserDto> {


}
