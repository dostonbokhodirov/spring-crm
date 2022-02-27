package uz.doston.springcrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.password.PasswordEncoder;
import uz.doston.springcrm.repository.auth.AuthRoleRepository;
import uz.doston.springcrm.repository.auth.AuthUserRepository;

@EnableJpaAuditing
@SpringBootApplication
public class SpringCrmApplication /*implements CommandLineRunner*/ {

//    private final AuthUserRepository authUserRepository;
//    private final AuthRoleRepository authRoleRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    public SpringCrmApplication(AuthUserRepository authUserRepository, AuthRoleRepository authRoleRepository, PasswordEncoder passwordEncoder) {
//        this.authUserRepository = authUserRepository;
//        this.authRoleRepository = authRoleRepository;
//        this.passwordEncoder = passwordEncoder;
//    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCrmApplication.class, args);
    }

//    @Transactional(timeout = 10)
//    public void run(String... args) throws Exception {
//        AuthUser admin = new AuthUser();
//        admin.setUsername("admin");
//        admin.setPassword(passwordEncoder.encode("admin123"));
//        admin.setFirstName("admin");
//        admin.setAge(22);
//        admin.setEmail("admin@mail.ru");
//        AuthRole adminRole = authRoleRepository.findAuthRoleByCode("ADMIN").orElse(new AuthRole());
//        adminRole.setCode("ADMIN");
//        adminRole.setName("Admin");
//        admin.setRole(adminRole);
//        admin.setCode(UUID.randomUUID());
//
//
//        AuthUser manager = new AuthUser();
//        manager.setUsername("manager");
//        manager.setPassword(passwordEncoder.encode("manager123"));
//        manager.setFirstName("manager");
//        manager.setAge(25);
//        manager.setEmail("manager@mail.ru");
//        manager.setCode(UUID.randomUUID());
//        AuthRole managerRole = authRoleRepository.findAuthRoleByCode("MANAGER").orElse(new AuthRole());
//        managerRole.setCode("MANAGER");
//        managerRole.setName("Manager");
//        manager.setRole(managerRole);
//
//        authUserRepository.saveAll(List.of(admin, manager));
//    }
}
