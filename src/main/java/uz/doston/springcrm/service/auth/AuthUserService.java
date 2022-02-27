package uz.doston.springcrm.service.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.doston.springcrm.dto.auth.AuthUserCreateDto;
import uz.doston.springcrm.dto.auth.AuthUserDto;
import uz.doston.springcrm.dto.auth.AuthUserUpdateDto;
import uz.doston.springcrm.entity.auth.AuthPermission;
import uz.doston.springcrm.entity.auth.AuthRole;
import uz.doston.springcrm.entity.auth.AuthUser;
import uz.doston.springcrm.enums.AuthPermissionType;
import uz.doston.springcrm.mapper.auth.AuthUserMapper;
import uz.doston.springcrm.repository.auth.AuthUserRepository;
import uz.doston.springcrm.service.base.AbstractService;
import uz.doston.springcrm.service.base.GenericCrudService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AuthUserService extends AbstractService<AuthUserMapper, AuthUserRepository>
        implements GenericCrudService<AuthUserCreateDto, AuthUserUpdateDto> {

    private final PasswordEncoder passwordEncoder;

    public AuthUserService(AuthUserMapper mapper, AuthUserRepository repository, PasswordEncoder passwordEncoder) {
        super(mapper, repository);
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void delete(Long id) {

    }

    @Transactional
    @Override
    public void create(AuthUserCreateDto authUserCreateDto) {
        String role = authUserCreateDto.getRole();
        List<AuthPermission> permissions = new ArrayList<>();
        if ("ADMIN".equals(role)) {
            for (AuthPermissionType authPermissionType : AuthPermissionType.values()) {
                String type = authPermissionType.toString();
                if (type.startsWith("MANAGER") || type.startsWith("PROJECT")) {
                    AuthPermission permission = new AuthPermission();
                    permission.setName(type);
                    permission.setCode(type);
                    permissions.add(permission);
                }
            }
        } else if ("MANAGER".equals(role)) {
            for (AuthPermissionType authPermissionType : AuthPermissionType.values()) {
                String type = authPermissionType.toString();
                if (type.startsWith("EMPLOYEE") || type.startsWith("TASK")) {
                    AuthPermission permission = new AuthPermission();
                    permission.setName(type);
                    permission.setCode(type);
                    permissions.add(permission);
                }
            }
        } else if ("EMPLOYEE".equals(role)) {
            for (AuthPermissionType authPermissionType : AuthPermissionType.values()) {
                String type = authPermissionType.toString();
                if (type.startsWith("TASK")) {
                    AuthPermission permission = new AuthPermission();
                    permission.setName(type);
                    permission.setCode(type);
                    permissions.add(permission);
                }
            }
        }
        AuthUser authUser = mapper.fromCreateDto(authUserCreateDto);
        AuthRole authRole = new AuthRole();
        authRole.setName(role);
        authRole.setCode(role);
        authRole.setPermissions(permissions);
        authUser.setRole(authRole);
        authUser.setPassword(passwordEncoder.encode(authUser.getPassword()));
        authUser.setCode(UUID.randomUUID());
        repository.save(authUser);
    }

    @Override
    public void update(AuthUserUpdateDto authUserUpdateDto) {

    }

    public List<AuthUserDto> getAllUsers(List<Long> membersId) {

        List<AuthUser> allById = repository.findAllById(membersId);
        return mapper.toDto(allById);
    }


}
