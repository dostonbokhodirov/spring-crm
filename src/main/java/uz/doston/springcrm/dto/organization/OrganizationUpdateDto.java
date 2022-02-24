package uz.doston.springcrm.dto.organization;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.geo.Point;
import uz.doston.springcrm.dto.BaseGenericDto;

@Getter
@Setter
@Builder(builderMethodName = "childBuilder")
public class OrganizationUpdateDto extends BaseGenericDto {

    private String name;

    private String logo;

    private String code;

    private Point location;

}
