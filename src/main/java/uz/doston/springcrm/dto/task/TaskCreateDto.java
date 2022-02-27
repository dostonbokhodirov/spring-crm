package uz.doston.springcrm.dto.task;

import lombok.Getter;
import lombok.Setter;
import uz.doston.springcrm.dto.BaseDto;

@Getter
@Setter
public class TaskCreateDto implements BaseDto {

    private String name;

    private String description;

    private Long ownerId;

    private Long projectId;

    private Long columnId;

    public TaskCreateDto(Long columnId) {
        this.columnId = columnId;
    }
}
