package uz.doston.springcrm.repository.organization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.doston.springcrm.dto.organization.OrganizationUpdateDto;
import uz.doston.springcrm.entity.organization.Organization;
import uz.doston.springcrm.repository.BaseRepository;

import javax.persistence.Column;
import javax.transaction.Transactional;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long>, BaseRepository {

    @Transactional
    @Modifying
    @Query(value = "update Organization set name = :#{#dto.name}, code = :#{#dto.code}, logo = :#{#dto.logo}, location = :#{#dto.location}")
    void update(@Param(value = "dto") OrganizationUpdateDto organizationUpdateDto);

    @Query(value = "select * from organization.organization where code = :code  ",nativeQuery = true)
    Organization findByCode(@Param("code") String code);
}
