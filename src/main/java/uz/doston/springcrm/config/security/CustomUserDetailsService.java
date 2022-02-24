//package uz.doston.springcrm.config.security;
//
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import uz.doston.springcrm.entity.auth.AuthUser;
//import uz.doston.springcrm.repository.auth.AuthUserRepository;
//
//import java.util.Optional;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private final AuthUserRepository authUserRepository;
//
//    public CustomUserDetailsService(AuthUserRepository authUserRepository) {
//        this.authUserRepository = authUserRepository;
//    }
//
//    @Override
//    public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        AuthUser authUser = authUserRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException(
//                        "User with name '%s' not found".formatted(username)
//                ));
//        return new MyUserDetails(authUser);
//    }
//}