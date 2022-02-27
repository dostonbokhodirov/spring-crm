package uz.doston.springcrm.dto.project;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import uz.doston.springcrm.dto.BaseGenericDto;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class ProjectDto extends BaseGenericDto {

    private String name;

    private String tzPath;

    private Long organizationId;

    private Boolean closed;

    private LocalDateTime createdAt;

    private LocalDateTime deadline;

}
