package uz.doston.springcrm.entity.comment;

import lombok.Getter;
import lombok.Setter;
import uz.doston.springcrm.entity.Auditable;
import uz.doston.springcrm.entity.auth.AuthUser;
import uz.doston.springcrm.enums.CommentType;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(schema = "comment")
public class Comment extends Auditable {

    @Column(nullable = false)
    private String text;

    @Column(name = "task_id", nullable = false)
    private Long taskId;

    @Column(name = "comment_type")
    @Enumerated(EnumType.STRING)
    private CommentType commentType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private AuthUser owner;
}
