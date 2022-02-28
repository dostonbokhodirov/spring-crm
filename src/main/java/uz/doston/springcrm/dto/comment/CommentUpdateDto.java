package uz.doston.springcrm.dto.comment;

import uz.doston.springcrm.dto.BaseGenericDto;
import uz.doston.springcrm.enums.CommentType;

public class CommentUpdateDto extends BaseGenericDto {

    private String text;

    private Long taskId;

    private CommentType commentType;
}
