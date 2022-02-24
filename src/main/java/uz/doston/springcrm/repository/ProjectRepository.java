package uz.doston.springcrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.doston.springcrm.entity.project.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>, BaseRepository {
}
