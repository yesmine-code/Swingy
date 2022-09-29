package org.yesmine.model.hero;

import org.yesmine.model.artefacts.Artefact;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

public abstract class Hero {
    @PositiveOrZero
    private Integer id;

    @Size(min = 0, max=10)
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
    private  Integer hitPoints;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Artefact getArtefact() {
        return artefact;
    }

    public void setArtefact(Artefact artefact) {
        this.artefact = artefact;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public void setDefence(Integer defence) {
        this.defence = defence;
    }

    public void setHitPoints(Integer hitPoints) {
        this.hitPoints = hitPoints;
    }

    public String getName() {
        return name;
    }

    public String getHeroClass() {
        return heroClass;
    }

    public Integer getLevel() {
        return level;
    }

    public Integer getExperience() {
        return experience;
    }

    public Integer getAttack() {
        return attack;
    }

    public Integer getDefence() {
        return defence;
    }

    public Integer getHitPoints() {
        return hitPoints;
    }


    public Integer computeMapSize(){
        return ((this.level - 1) * 5 + 10 - (this.level % 2));
    }

    public void computeLevel(){
        level = 1;
        while ((level * 1000) + (level - 1) * (level - 1) * 450 < experience)
            level++;
    }

    public Integer getId() {
        return id;
    }

    public Position getPreviousPosition() {
        return previousPosition;
    }

    public void setPreviousPosition(Position previousPosition) {
        this.previousPosition = previousPosition;
    }

    public void setId(Integer id) {
        this.id = id;
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
