package model.hero;

import model.artefacts.Artefact;

public class Chevalier extends Hero{
    public Chevalier(String name, Integer level, Integer experience, Integer attack, Integer defence, Integer hitPoints, Artefact artefacts) {
        super(name, "Chevalier", level, experience, attack, defence , hitPoints, artefacts);
    }
}
