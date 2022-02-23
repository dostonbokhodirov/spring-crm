package uz.doston.springcrm.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.doston.springcrm.entity.auth.AuthRole;
import uz.doston.springcrm.repository.BaseRepository;

@Repository
public interface AuthRoleRepository extends JpaRepository<AuthRole, Long>, BaseRepository {
}
