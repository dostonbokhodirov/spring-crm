package uz.doston.springcrm.repository.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.doston.springcrm.entity.project.Project;
import uz.doston.springcrm.repository.BaseRepository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>, BaseRepository {

}
