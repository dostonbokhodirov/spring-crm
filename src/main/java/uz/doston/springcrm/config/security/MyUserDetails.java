package uz.doston.springcrm.config.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.doston.springcrm.entity.auth.AuthRole;
import uz.doston.springcrm.entity.auth.AuthUser;
import uz.doston.springcrm.enums.Status;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MyUserDetails implements UserDetails {

    private final Long id;

    private final String username;

    private final String password;

    private final boolean enabled;

    private final Status status;

    private final String email;

    private final Long organizationId;

    private Set<SimpleGrantedAuthority> authorities;

    public MyUserDetails(AuthUser user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.status = user.getStatus();
        this.email = user.getEmail();
        this.organizationId = user.getOrganizationId();
        this.enabled = true;
        this.authorities = new HashSet<>();
        processAuthorities(user.getRole());
    }


    private void processAuthorities(AuthRole role) {
        if (Objects.isNull(role)) return;
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getCode()));

        if (Objects.isNull(role.getPermissions())) return;

        role.getPermissions().forEach(permission -> authorities.add(new SimpleGrantedAuthority(permission.getCode())));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
