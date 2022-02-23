package uz.doston.springcrm.entity.task;


import lombok.Getter;
import lombok.Setter;
import uz.doston.springcrm.entity.Auditable;
import uz.doston.springcrm.entity.project.ProjectColumn;
import uz.doston.springcrm.entity.project.ProjectMember;
import uz.doston.springcrm.enums.Level;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(schema = "task")
public class Task extends Auditable {

    @ManyToOne
    @JoinColumn(name="project_column_id", nullable=false)
    private ProjectColumn projectColumn;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            schema = "task",
            name = "task_member",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "project_member_id"))
    private List<ProjectMember> projectMembers;


    @Column(nullable = false)
    private Long projectId;

    @Column(nullable = false)
    private Long ownerId;

    @Column(nullable = false)
    private String name;

    private String description;

    private Level level;

    private Date deadline;

    private Integer priority;

    private boolean completed;


}
