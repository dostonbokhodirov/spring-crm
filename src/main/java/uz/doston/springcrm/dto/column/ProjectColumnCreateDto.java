package uz.doston.springcrm.dto.column;

import lombok.Getter;
import lombok.Setter;
import uz.doston.springcrm.dto.BaseDto;
import uz.doston.springcrm.dto.BaseGenericDto;
import uz.doston.springcrm.dto.task.TaskDto;
import uz.doston.springcrm.entity.icon.Icon;
import uz.doston.springcrm.entity.task.Task;

import java.util.List;

@Getter
@Setter
public class ProjectColumnCreateDto implements BaseDto {

    private String name;

    private Long projectId;

    private List<Task> tasks; // dto bo'lishi kerak

    private Long orderNumber;

    private Icon icon;

}
