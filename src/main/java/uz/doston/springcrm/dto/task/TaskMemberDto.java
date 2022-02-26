package uz.doston.springcrm.dto.task;


import lombok.Getter;
import lombok.Setter;
import uz.doston.springcrm.dto.BaseGenericDto;
import uz.doston.springcrm.entity.auth.AuthUser;
import uz.doston.springcrm.entity.task.Task;

@Getter
@Setter
public class TaskMemberDto extends BaseGenericDto {

    private AuthUser authUser;

    private Task task;

}
