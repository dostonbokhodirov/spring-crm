package uz.doston.springcrm.configs.annotations;

import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('ADMIN')")
public @interface HasAdminRole {
}
