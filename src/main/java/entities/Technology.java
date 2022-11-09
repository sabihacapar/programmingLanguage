package entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Table(name = "technologies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Technology {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "technologyId")
    private int technologyId;
    @Column(name= "technologyName")
    private String technologyName;

    @ManyToOne
    private Language language;

}