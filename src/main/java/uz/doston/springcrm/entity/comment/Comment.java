package uz.doston.springcrm.entity.comment;

import lombok.Getter;
import lombok.Setter;
import uz.doston.springcrm.enums.CommentType;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(schema = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String text;

    @Column(name = "task_id", nullable = false)
    private Long taskId;

    @Column(name = "comment_type")
    @Enumerated(EnumType.STRING)
    private CommentType commentType;
}
