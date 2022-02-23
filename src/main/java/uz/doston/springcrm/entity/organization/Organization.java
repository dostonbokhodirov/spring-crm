package uz.doston.springcrm.entity.organization;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.geo.Point;
import uz.doston.springcrm.entity.Auditable;
import uz.doston.springcrm.entity.auth.AuthUser;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Organization extends Auditable {

    @Column(unique = true, nullable = false)
    private String name;

    @Column
    private String logo;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private AuthUser owner;

    private String email;

    private String code;

    private Point location;

}
