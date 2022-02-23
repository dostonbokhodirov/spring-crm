package uz.doston.springcrm.dto.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.doston.springcrm.dto.BaseGenericDto;

@Getter
@Setter
@Builder(builderMethodName = "childBuilder")
public class AuthUserUpdateDto extends BaseGenericDto {

}
