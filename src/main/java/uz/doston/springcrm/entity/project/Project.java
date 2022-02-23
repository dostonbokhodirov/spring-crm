package uz.doston.springcrm.entity.project;


import lombok.Getter;
import lombok.Setter;
import uz.doston.springcrm.entity.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Getter
@Setter
@Entity
@Table(schema = "project")
public class Project extends Auditable {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String tzPath;

    private Long organizationId;

    private boolean closed;


}
