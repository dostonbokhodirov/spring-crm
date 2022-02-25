package uz.doston.springcrm.repository.organization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.doston.springcrm.entity.organization.Logo;
import uz.doston.springcrm.repository.BaseRepository;

@Repository
public interface OrganizationLogoRepository extends JpaRepository<Logo, Long>, BaseRepository {

}
