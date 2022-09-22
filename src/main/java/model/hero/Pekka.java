package model.hero;

import model.artefacts.Artefact;

public class Pekka extends Hero{
    public Pekka(String name, Integer level, Integer experience, Integer attack, Integer defence, Integer hitPoints, Artefact artefacts) {
        super(name, "Pekka", level, experience, attack, defence , hitPoints, artefacts);
    }
}
