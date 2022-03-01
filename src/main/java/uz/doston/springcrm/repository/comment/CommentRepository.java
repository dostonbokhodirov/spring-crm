package uz.doston.springcrm.repository.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.doston.springcrm.entity.comment.Comment;
import uz.doston.springcrm.repository.BaseRepository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>, BaseRepository {

    @Modifying
    @Query(value = "select * from comment.comment where task_id = :id", nativeQuery = true)
//    @Query(value = "select c from Comment c where c.taskId = :id")
    List<Comment> findAllByTaskId(@Param(value = "id") Long id);
}
