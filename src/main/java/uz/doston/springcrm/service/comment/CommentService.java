package uz.doston.springcrm.service.comment;

import org.springframework.stereotype.Service;
import uz.doston.springcrm.dto.comment.CommentCreateDto;
import uz.doston.springcrm.dto.comment.CommentDto;
import uz.doston.springcrm.dto.comment.CommentUpdateDto;
import uz.doston.springcrm.entity.comment.Comment;
import uz.doston.springcrm.mapper.comment.CommentMapper;
import uz.doston.springcrm.repository.comment.CommentRepository;
import uz.doston.springcrm.service.base.AbstractService;
import uz.doston.springcrm.service.base.GenericCrudService;
import uz.doston.springcrm.service.base.GenericService;

import java.io.IOException;
import java.util.List;

@Service
public class CommentService extends AbstractService<CommentMapper, CommentRepository>
        implements GenericCrudService<CommentCreateDto, CommentUpdateDto>, GenericService<CommentDto> {

    public CommentService(CommentMapper mapper, CommentRepository repository) {
        super(mapper, repository);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void create(CommentCreateDto commentCreateDto) {

    }

    @Override
    public void update(CommentUpdateDto commentUpdateDto) throws IOException {

    }

    @Override
    public List<CommentDto> getAll() {
        return null;
    }

    @Override
    public CommentDto get(Long id) {
        return null;
    }

    public List<CommentDto> getAllByTaskId(Long id) {
        List<Comment> comments = repository.findAllByTaskId(id);
        List<CommentDto> commentDtoList = mapper.toDto(comments);
        for (CommentDto dto : commentDtoList) {
            for (Comment comment : comments) {
                dto.setOwnerName(comment.getOwner().getFirstName());
            }
        }
        return commentDtoList;
    }
}
