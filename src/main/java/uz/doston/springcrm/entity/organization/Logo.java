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
    private String generatedName;
    private String imageName;
    private String format;
    private Long size;
}
