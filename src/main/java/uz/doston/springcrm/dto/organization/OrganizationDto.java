package uz.doston.springcrm.dto.organization;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.geo.Point;
import org.springframework.web.multipart.MultipartFile;
import uz.doston.springcrm.dto.BaseGenericDto;
import uz.doston.springcrm.entity.organization.Logo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder(builderMethodName = "childBuilder")
public class OrganizationDto extends BaseGenericDto {
    private String name;

    private String code;

    private String email;

    private Logo logo;

    private String logoPath;

    private Point location;

}
