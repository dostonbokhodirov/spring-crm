package uz.doston.springcrm.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.doston.springcrm.dto.BaseGenericDto;

@Getter
@Setter
@Builder(builderMethodName = "childBuilder")
public class ProjectDto extends BaseGenericDto {

    private String name;

    private String tzPath;

    private Long organizationId;

    private Boolean closed;
}
