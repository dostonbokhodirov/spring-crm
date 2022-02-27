package uz.doston.springcrm.entity.organization;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.geo.Point;
import uz.doston.springcrm.entity.Auditable;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(schema = "organization")
public class Organization extends Auditable {

    @Column(unique = true, nullable = false)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "logo_id", nullable = false)
    private Logo logo;

    @Column(name = "owner_id", nullable = false)
    private Long ownerId;

    @Column
    private String email;

    @Column
    private String code = UUID.randomUUID().toString().replace("-", "");

    @Column
    private Point location;

}
