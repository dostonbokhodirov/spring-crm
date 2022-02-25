package uz.doston.springcrm.dto.task;


import lombok.Getter;
import lombok.Setter;
import uz.doston.springcrm.dto.BaseGenericDto;

@Getter
@Setter
public class TaskMemberDto extends BaseGenericDto {

    private Long userId;

    private Long projectColumnId;

    private Long taskId;

}
