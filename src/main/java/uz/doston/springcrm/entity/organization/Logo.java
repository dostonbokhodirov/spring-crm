package uz.doston.springcrm.entity.organization;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(schema = "organization")
public class Logo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "generated_name")
    private String generatedName;

    @Column(name = "image_name")
    private String imageName;

    @Column
    private String format;

    @Column
    private Long size;
}
