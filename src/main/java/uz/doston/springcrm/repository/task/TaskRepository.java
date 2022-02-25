package uz.doston.springcrm.repository.task;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.doston.springcrm.entity.task.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByProjectId( Long id);

}
