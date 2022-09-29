package com.projects.model.villain;

import com.projects.model.artefacts.Artefact;

public abstract class Villain {
    private String name;
    private final String villainClass;
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
