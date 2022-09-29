package com.projects.model.hero;

import com.projects.model.artefacts.Artefact;

public class Chevalier extends Hero{
    public Chevalier(Integer id, String name, Integer experience, Integer attack, Integer defence, Integer hitPoints, Artefact artefacts) {
        super(id, name, "Chevalier", experience, attack, defence , hitPoints, artefacts);
    }
}
