package uz.doston.springcrm.entity.task;


import lombok.Getter;
import lombok.Setter;
import uz.doston.springcrm.entity.Auditable;
import uz.doston.springcrm.entity.auth.AuthUser;
import uz.doston.springcrm.enums.Level;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(schema = "task")
public class Task extends Auditable {

    @Column(nullable = false, name = "project_id")
    private Long projectId;

    @Column(name = "column_id")
    private Long columnId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            schema = "task",
            name = "task_member",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<AuthUser> taskMembers;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, name = "owner_id")
    private Long ownerId;

    @Column
    private String description;

    @Column
    @Enumerated(EnumType.STRING)
    private Level level;

    @Column(columnDefinition = "timestamp")
    private Date deadline;

    @Column
    private Integer priority;

    @Column
    private boolean completed = false;

    @Column
    private boolean frozen = false;


}
