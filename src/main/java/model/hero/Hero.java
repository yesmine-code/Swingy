package model.hero;

import model.artefacts.Artefact;

public abstract class Hero {
    private String name;
    private final String heroClass;
    private Integer level;
    private Integer experience;
    private Integer attack;
    private Integer defence;
    private  Integer hitPoints;
    private Position position;

    public Hero(String name, String heroClass, Integer level, Integer experience, Integer attack, Integer defence, Integer hitPoints, Artefact artefact) {
        this.name = name;
        this.heroClass = heroClass;
        this.level = level;
        this.experience = experience;
        this.attack = attack;
        this.defence = defence;
        this.hitPoints = hitPoints;
        this.artefact = null;
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

    private Artefact artefact;

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






}
