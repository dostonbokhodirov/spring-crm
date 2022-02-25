package uz.doston.springcrm.dto.column;

import lombok.Getter;
import lombok.Setter;
import uz.doston.springcrm.dto.BaseGenericDto;
import uz.doston.springcrm.dto.task.TaskDto;

import java.util.List;

@Getter
@Setter
public class ProjectColumnDto extends BaseGenericDto {

    private List<TaskDto> tasks;

    private String name;

    private Long orderNumber;

    private Long iconId;

    private boolean active;
}
