package uz.doston.springcrm.service.auth;

import org.springframework.stereotype.Service;
import uz.doston.springcrm.mapper.AuthUserMapper;
import uz.doston.springcrm.repository.auth.AuthUserRepository;
import uz.doston.springcrm.service.base.AbstractService;
import uz.doston.springcrm.service.base.BaseService;

@Service
public class AuthUserService extends AbstractService<AuthUserMapper, AuthUserRepository> implements BaseService {

    public AuthUserService(AuthUserMapper mapper, AuthUserRepository repository) {
        super(mapper, repository);
    }
}
