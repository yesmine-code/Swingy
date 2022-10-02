package org.yesmine.dao.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "heroes")
@Getter
@Setter
public class HeroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String heroName;

    @NotNull
    private String heroClass;

    private Integer xp;

    private String artefact;


}
