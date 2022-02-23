package uz.doston.springcrm.entity.auth;

import lombok.Getter;
import lombok.Setter;
import uz.doston.springcrm.entity.Auditable;
import uz.doston.springcrm.enums.Language;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(schema = "auth")
public class AuthUser extends Auditable {


    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String firstName;

    @Column
    private String lastName;

    @Column(nullable = false)
    private Integer age;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private UUID code;

    @Column(name = "organization_id")
    private Long organizationId;

    @Column(name = "role_id")
    private Long roleId;

    @Column
    private Language language;
}
