package uz.doston.springcrm.repository.column;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.doston.springcrm.dto.column.ProjectColumnUpdateDto;
import uz.doston.springcrm.dto.organization.OrganizationUpdateDto;
import uz.doston.springcrm.entity.project.ProjectColumn;
import uz.doston.springcrm.repository.BaseRepository;

import java.util.List;


@Repository
public interface ProjectColumnRepository extends JpaRepository<ProjectColumn, Long>, BaseRepository {

    List<ProjectColumn> findProjectColumnsByProjectId(Long id);

    @Modifying
    @Query(value = "update ProjectColumn set name = :#{#dto.name}, projectId = :#{#dto.projectId}, orderNumber = :#{#dto.orderNumber}, icon = :#{#dto.icon}, active = :#{#dto.active} ")
    void update(@Param(value = "dto") ProjectColumn column);

}
