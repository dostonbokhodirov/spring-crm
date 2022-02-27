package uz.doston.springcrm.entity.project;


import lombok.Getter;
import lombok.Setter;
import uz.doston.springcrm.entity.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(schema = "project")
public class Project extends Auditable {

    @Column(nullable = false)
    private String name;

    @Column(name = "tz_path", nullable = false)
    private String tzPath;

    @Column(name = "organization_id")
    private Long organizationId;

    @Column
    private LocalDateTime deadline;

    @Column
    private boolean closed;

}
