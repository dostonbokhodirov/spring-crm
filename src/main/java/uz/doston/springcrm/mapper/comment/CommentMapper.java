package uz.doston.springcrm.mapper.comment;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import uz.doston.springcrm.dto.comment.CommentDto;
import uz.doston.springcrm.entity.comment.Comment;
import uz.doston.springcrm.mapper.BaseMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface CommentMapper extends BaseMapper {

    CommentDto toDto(Comment comment);

    @Mapping(target = "owner", ignore = true)
    List<CommentDto> toDto(List<Comment> comments);
}
