package model.hero;

import model.artefacts.Artefact;

public class Sorcier extends Hero{
    public Sorcier(String name, Integer level, Integer experience, Integer attack, Integer defence, Integer hitPoints, Artefact artefacts) {
        super(name, "Sorcier", level, experience, attack, defence , hitPoints, artefacts);
    }
}
