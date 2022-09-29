package com.projects.model.hero;

import com.projects.model.artefacts.Artefact;

public class Sorcier extends Hero{
    public Sorcier(Integer id, String name, Integer experience, Integer attack, Integer defence, Integer hitPoints, Artefact artefacts) {
        super(id, name, "Sorcier", experience, attack, defence , hitPoints, artefacts);
    }
}
