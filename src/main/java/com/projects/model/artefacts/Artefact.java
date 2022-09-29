package com.projects.model.artefacts;

public abstract class Artefact {
    private String name;
    private Integer attackAffect;
    private Integer defenceAffect;
    private Integer hitPointsAffect;

    public Artefact(String name, Integer attackAffect, Integer defenceAffect, Integer hitPointsAffect) {
        this.name = name;
        this.attackAffect = attackAffect;
        this.defenceAffect = defenceAffect;
        this.hitPointsAffect = hitPointsAffect;
    }

    public String getName() {
        return name;
    }

    public Integer getAttackAffect() {
        return attackAffect;
    }

    public Integer getDefenceAffect() {
        return defenceAffect;
    }

    public Integer getHitPointsAffect() {
        return hitPointsAffect;
    }

    @Override
    public String toString() {
        return name;
    }
}
