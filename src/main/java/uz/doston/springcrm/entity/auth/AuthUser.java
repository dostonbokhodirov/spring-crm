package uz.doston.springcrm.entity.auth;

import lombok.Getter;
import lombok.Setter;
import uz.doston.springcrm.entity.Auditable;
import uz.doston.springcrm.enums.Language;
import uz.doston.springcrm.enums.Status;

import javax.persistence.*;
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

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "organization_id")
    private Long organizationId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private AuthRole role;

    @Column
    @Enumerated(EnumType.STRING)
    private Language language;

    @Column
    private boolean deleted;
}
