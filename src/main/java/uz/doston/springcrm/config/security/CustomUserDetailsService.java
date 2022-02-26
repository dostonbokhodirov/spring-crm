package uz.doston.springcrm.config.security;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.doston.springcrm.entity.auth.AuthUser;
import uz.doston.springcrm.repository.auth.AuthUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    public CustomUserDetailsService(AuthUserRepository authUserRepository) {
        this.authUserRepository = authUserRepository;
    }

    private final AuthUserRepository authUserRepository;

    @Override
    public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser authUser = authUserRepository.findByUsername(username);
        return new MyUserDetails(authUser);
    }
}