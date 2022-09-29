package org.yesmine.model.artefacts;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public abstract class Artefact {
    @NotNull
    private String name;
    @PositiveOrZero
    private Integer attackAffect;
    @PositiveOrZero
    private Integer defenceAffect;
    @PositiveOrZero
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
