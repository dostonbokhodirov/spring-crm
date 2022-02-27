//package uz.doston.springcrm.entity.task;
//
//import lombok.Getter;
//import lombok.Setter;
//import uz.doston.springcrm.entity.auth.AuthUser;
//import uz.doston.springcrm.entity.project.ProjectColumn;
//
//import javax.persistence.*;
//
//@Getter
//@Setter
//@Entity
//@Table(schema = "task")
//public class TaskMember {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @OneToOne
//    @JoinColumn(name="user_id", nullable=false)
//    private AuthUser userId;
//
//    @OneToOne
//    @JoinColumn(name = "project_column_id",nullable = false)
//    private ProjectColumn projectColumn;
//
//    @OneToOne
//    @JoinColumn(name = "task_id")
//    private Task taskId;
//
//}
