package uz.doston.springcrm.dto.task;

import lombok.Getter;
import lombok.Setter;
import uz.doston.springcrm.dto.BaseGenericDto;
import uz.doston.springcrm.dto.auth.AuthUserDto;
import uz.doston.springcrm.enums.Level;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class TaskUpdateDto extends BaseGenericDto {

    private Long columnId;

    private List<AuthUserDto> taskMembers;

    private String name;

    private String description;

    private Level level;

    private Date deadline;

    private Integer priority;

    private boolean completed;

}
