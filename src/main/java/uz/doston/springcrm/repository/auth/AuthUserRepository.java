package uz.doston.springcrm.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.doston.springcrm.entity.auth.AuthUser;
import uz.doston.springcrm.repository.BaseRepository;

import java.util.Optional;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Long>, BaseRepository {
    Optional<AuthUser> findAuthUserByUsername(String username);
}
