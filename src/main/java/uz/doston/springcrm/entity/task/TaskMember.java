package uz.doston.springcrm.entity.task;

import lombok.Getter;
import lombok.Setter;
import uz.doston.springcrm.entity.auth.AuthUser;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(schema = "task")
public class TaskMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AuthUser authUser;

}
