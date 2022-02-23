package uz.doston.springcrm.dto.organization;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.geo.Point;
import uz.doston.springcrm.dto.BaseDto;

@Getter
@Setter
@Builder
public class OrganizationCreateDto implements BaseDto {

    private String name;

    private String logo;

    private String code;

    private Point location;

}
