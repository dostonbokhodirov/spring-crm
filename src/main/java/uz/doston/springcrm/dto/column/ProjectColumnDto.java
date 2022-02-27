package uz.doston.springcrm.dto.column;

import lombok.Getter;
import lombok.Setter;
import uz.doston.springcrm.dto.BaseGenericDto;
import uz.doston.springcrm.dto.task.TaskDto;
import uz.doston.springcrm.entity.icon.Icon;
import uz.doston.springcrm.entity.task.Task;

import java.util.List;

@Getter
@Setter
public class ProjectColumnDto extends BaseGenericDto {

    private String name;

    private Long projectId;

    private List<TaskDto> tasks;

    private Long orderNumber;

    private Icon icon;

    private boolean active;
}
