package uz.doston.springcrm.repository.task;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.doston.springcrm.entity.task.TaskMember;
import uz.doston.springcrm.repository.BaseRepository;

import java.util.List;

public interface TaskMemberRepository extends JpaRepository<TaskMember,Long>, BaseRepository {


    List<TaskMember> findAllByProjectColumnId(Long id);



//    List<TaskMember> (List<Long> ids);

}
