package org.yesmine.model.hero;

import lombok.Getter;
import lombok.Setter;
import org.yesmine.model.artefacts.Artefact;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Getter
@Setter
public abstract class Hero {
    @PositiveOrZero
    private Integer id;

    @Size(min = 0, max = 10)
    private String name;
    @NotNull
    private final String heroClass;
    @Min(1)
    private Integer level;
    @Min(1000)
    private Integer experience;
    @PositiveOrZero
    private Integer attack;
    @PositiveOrZero
    private Integer defence;
    @PositiveOrZero
    private Integer hitPoints;
    private Position position;

    private Position previousPosition;


    private Artefact artefact;


    public Hero(Integer id, String name, String heroClass,
                Integer experience, Integer attack, Integer defence, Integer hitPoints, Artefact artefact) {
        this.id = id;
        this.name = name;
        this.heroClass = heroClass;
        this.experience = experience;
        this.attack = attack;
        this.defence = defence;
        this.hitPoints = hitPoints;
        this.artefact = artefact;
    }


    public Integer computeMapSize() {
        return ((this.level - 1) * 5 + 10 - (this.level % 2));
    }

    public void computeLevel() {
        level = 1;
        while ((level * 1000) + (level - 1) * (level - 1) * 450 < experience)
            level++;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", heroClass='" + heroClass + '\'' +
                ", attack=" + attack +
                ", defence=" + defence +
                ", hitPoints=" + hitPoints +
                ", artefact=" + artefact +
                '}';
    }
}
