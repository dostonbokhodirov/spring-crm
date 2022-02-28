package uz.doston.springcrm.dto.column;


import lombok.Getter;
import lombok.Setter;
import uz.doston.springcrm.dto.BaseGenericDto;
import uz.doston.springcrm.entity.icon.Icon;

@Getter
@Setter
public class ProjectColumnUpdateDto extends BaseGenericDto {

    private String name;

    private Long projectId;

    private Long orderNumber;

    private Icon icon;

    private boolean active;

}
