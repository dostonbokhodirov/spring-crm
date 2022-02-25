package uz.doston.springcrm.dto.project.member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectMemberDto {

    private Long id;

    private Long userId;

    private Long projectId;

    private boolean lead;

}
