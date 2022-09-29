package com.projects.model.hero;

public enum HeroEnum {
    VALKYRIE(500,300,500),
    SORCIER(400,400,400),
    CHEVALIER(700,250,700),
    PEKKA(700,300,600),
    PRINCE(600,350,600),
    VOLEUSE(400,500, 500),
    DRAGON(450,300,550);

    private Integer attack;
    private Integer defence;
    private Integer hitPoints;


    HeroEnum(Integer attack, Integer defence, Integer hitPoints) {
        this.attack = attack;
        this.defence = defence;
        this.hitPoints = hitPoints;
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
}
