package uz.doston.springcrm.dto.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.doston.springcrm.dto.BaseGenericDto;
import uz.doston.springcrm.entity.auth.AuthRole;
import uz.doston.springcrm.enums.Language;
import uz.doston.springcrm.enums.Status;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import java.util.UUID;

@Getter
@Setter
@Builder(builderMethodName = "childBuilder")
public class AuthUserDto extends BaseGenericDto {

    private String username;

    private String firstName;

    private String lastName;

    private Integer age;

    private String email;


    private Long organizationId;

    private AuthRole role;

    private Language language;

    private boolean deleted;

}
