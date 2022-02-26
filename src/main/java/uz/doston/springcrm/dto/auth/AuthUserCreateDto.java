package uz.doston.springcrm.dto.auth;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import uz.doston.springcrm.dto.BaseDto;

import java.util.UUID;

@Getter
@Setter
@ToString
public class AuthUserCreateDto implements BaseDto {

    private String username;

    private String firstName;

    private String lastName;

    private Integer age;

    private String email;

    private String password;

    private UUID code;

    private Long organizationId;

    private String role;

}
