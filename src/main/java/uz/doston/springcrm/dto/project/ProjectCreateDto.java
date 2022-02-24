package uz.doston.springcrm.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.doston.springcrm.dto.BaseDto;

@Getter
@Setter
//@Builder
public class ProjectCreateDto implements BaseDto {

    private String name;

    private String tzPath;

    private Long organizationId;

}
