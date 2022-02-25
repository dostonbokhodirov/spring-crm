package uz.doston.springcrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.doston.springcrm.entity.task.Task;

public interface TaskRepository extends JpaRepository<Task, Long>, BaseRepository {

}
