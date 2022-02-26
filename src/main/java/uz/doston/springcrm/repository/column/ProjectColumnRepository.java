package uz.doston.springcrm.repository.column;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.doston.springcrm.entity.project.ProjectColumn;
import uz.doston.springcrm.repository.BaseRepository;

import java.util.List;


@Repository
public interface ProjectColumnRepository extends JpaRepository<ProjectColumn, Long>, BaseRepository {

    List<ProjectColumn> findProjectColumnsByProjectId(Long id);

}
