package uz.doston.springcrm.dto.task;


import lombok.Getter;
import lombok.Setter;
import uz.doston.springcrm.dto.auth.AuthUserDto;

import java.util.List;

@Getter
@Setter
public class TaskMemberDto {

    private Long id;

    private List<AuthUserDto> users;

    private Long memberId;//project_member_id

    private Long projectColumnId;
}
