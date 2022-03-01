package uz.doston.springcrm.dto.comment;

import lombok.Getter;
import lombok.Setter;
import uz.doston.springcrm.dto.BaseGenericDto;
import uz.doston.springcrm.enums.CommentType;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentDto extends BaseGenericDto {

    private String text;

    private Long taskId;

    private CommentType commentType;

    private String ownerName;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
