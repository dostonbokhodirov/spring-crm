package uz.doston.springcrm.repository.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.doston.springcrm.entity.task.Task;
import uz.doston.springcrm.repository.BaseRepository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>, BaseRepository {

    List<Task> findAllByProjectId(Long id);

    Task findTaskById(Long id);


}
