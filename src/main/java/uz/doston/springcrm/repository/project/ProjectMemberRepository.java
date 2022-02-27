package uz.doston.springcrm.repository.project;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.doston.springcrm.entity.project.ProjectMember;
import uz.doston.springcrm.repository.BaseRepository;

import java.util.List;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember,Long>, BaseRepository {


    List<ProjectMember>  findProjectMembersByProjectId(Long id);

    List<ProjectMember> findAllByProjectId(Long id);

}
