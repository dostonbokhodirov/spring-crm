//package uz.doston.springcrm.entity.project;
//
//
//import lombok.Getter;
//import lombok.Setter;
//import uz.doston.springcrm.entity.Auditable;
//
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//
//@Getter
//@Setter
//@Entity
//@Table(schema = "project")
//public class ProjectColumn extends Auditable {
//
//    @OneToMany(mappedBy = "projectColumn")
//    private List<Task> tasks;
//
//    @Column(nullable = false)
//    private String name;
//
//    @Column(name = "project_id")
//    private Long projectId;
//
//    @Column(nullable = false, unique = true, name = "order_number")
//    private Long orderNumber;
//
//    private Long iconId;
//
//    private boolean active = true;
//
//}
