package uz.doston.springcrm.dto.organization;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.geo.Point;
import org.springframework.web.multipart.MultipartFile;
import uz.doston.springcrm.dto.BaseGenericDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
//@Builder(builderMethodName = "childBuilder")
@NoArgsConstructor
public class OrganizationUpdateDto extends BaseGenericDto {

    @Size(min = 1,max = 30,message = "value for title must be between {min} and {max}")
    private String name;

    //    @NotNull(message = "Please input logo")
    private MultipartFile logo;

    private String code;

    private Point location;

    private String email;

}
