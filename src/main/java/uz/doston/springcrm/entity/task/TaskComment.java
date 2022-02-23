package uz.doston.springcrm.entity.task;


import lombok.Getter;
import lombok.Setter;
import uz.doston.springcrm.entity.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(schema = "task")
public class TaskComment extends Auditable {

    private String comment;

    @Column(name = "task_id")
    private Long taskId;

    // private String commentType;

}
