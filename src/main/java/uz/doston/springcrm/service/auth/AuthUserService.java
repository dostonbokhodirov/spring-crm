package uz.doston.springcrm.service.auth;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import uz.doston.springcrm.dto.auth.AuthUserCreateDto;
import uz.doston.springcrm.dto.auth.AuthUserDto;
import uz.doston.springcrm.dto.auth.AuthUserUpdateDto;
import uz.doston.springcrm.mapper.AuthUserMapper;
import uz.doston.springcrm.repository.auth.AuthUserRepository;
import uz.doston.springcrm.service.base.AbstractService;
import uz.doston.springcrm.service.base.GenericCrudService;
import uz.doston.springcrm.service.base.GenericService;

import java.util.List;

@Service
public class AuthUserService extends AbstractService<AuthUserMapper, AuthUserRepository>
        implements GenericCrudService<AuthUserCreateDto, AuthUserUpdateDto>, GenericService<AuthUserDto> {

    public AuthUserService(/*@Qualifier(value = "authUserMapper")*/ AuthUserMapper mapper, AuthUserRepository repository) {
        super(mapper, repository);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void create(AuthUserCreateDto authUserCreateDto) {

    }

    @Override
    public void update(AuthUserUpdateDto authUserUpdateDto) {

    }

    @Override
    public List<AuthUserDto> getAll() {
        return null;
    }

    @Override
    public AuthUserDto get(Long id) {
        return null;
    }

}
