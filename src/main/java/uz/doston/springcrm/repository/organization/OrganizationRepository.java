package uz.doston.springcrm.repository.organization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.doston.springcrm.entity.organization.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
