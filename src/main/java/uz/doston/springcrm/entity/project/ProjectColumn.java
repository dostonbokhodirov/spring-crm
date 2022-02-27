package uz.doston.springcrm.entity.project;


import lombok.Getter;
import lombok.Setter;
import uz.doston.springcrm.entity.Auditable;
import uz.doston.springcrm.entity.icon.Icon;
import uz.doston.springcrm.entity.task.Task;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(schema = "project")
public class ProjectColumn extends Auditable {

    @Column(nullable = false)
    private String name;

    @Column(name = "project_id")
    private Long projectId;

    @Column(nullable = false, unique = true, name = "order_number")
    private Long orderNumber;

    @OneToMany(mappedBy = "columnId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Task> tasks;

    @OneToOne
    @JoinColumn(name = "icon_id")
    private Icon icon;

    @Column
    private boolean active = true;

}
