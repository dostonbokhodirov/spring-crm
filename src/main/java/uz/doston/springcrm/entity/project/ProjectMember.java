package uz.doston.springcrm.entity.project;

import lombok.Getter;
import lombok.Setter;
import uz.doston.springcrm.entity.auth.AuthUser;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(schema = "project")
public class ProjectMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AuthUser authUser;

    @OneToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    private boolean lead;

}
