package org.yesmine.model.villain;

import org.yesmine.model.artefacts.Artefact;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public abstract class Villain {
    @NotNull
    private String name;
    @NotNull
    private final String villainClass;
    @Min(0)
    private Integer power;
    private Artefact artefact;

    protected Villain(String name, String villainClass, Integer power, Artefact artefact) {
        this.name = name;
        this.villainClass = villainClass;
        this.power = power;
        this.artefact = artefact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVillainClass() {
        return villainClass;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Artefact getArtefact() {
        return artefact;
    }

    public void setArtefact(Artefact artefact) {
        this.artefact = artefact;
    }
}
