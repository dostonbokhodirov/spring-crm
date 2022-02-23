package uz.doston.springcrm.entity.organization;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.geo.Point;
import uz.doston.springcrm.entity.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(schema = "organization")
public class Organization extends Auditable {

    @Column(unique = true, nullable = false)
    private String name;

    @Column
    private String logo;

    @Column(name = "owner_id", nullable = false)
    private Long ownerId;

    @Column
    private String email;

    @Column
    private String code;

    @Column
    private Point location;

    @Column
    private Boolean isActive;

}
