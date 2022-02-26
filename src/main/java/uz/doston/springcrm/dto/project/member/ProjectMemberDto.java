package uz.doston.springcrm.dto.project.member;

import lombok.Getter;
import lombok.Setter;
import uz.doston.springcrm.dto.BaseGenericDto;

@Getter
@Setter
public class ProjectMemberDto extends BaseGenericDto {

    private Long userId;

    private Long projectId;

    private boolean lead;

}
