package uz.doston.springcrm.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.doston.springcrm.entity.auth.AuthUser;
import uz.doston.springcrm.repository.BaseRepository;


@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Long>, BaseRepository {

    @Query(value = "select * from auth.auth_user where username = :username", nativeQuery = true)
    AuthUser findByUsername(@Param(value = "username") String username);


}
