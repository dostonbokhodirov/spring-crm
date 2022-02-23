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

    private Long owner_id;

    private String email;

    private String code;

    private Point location;

}
