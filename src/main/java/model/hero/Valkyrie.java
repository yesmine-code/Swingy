package model.hero;

import model.artefacts.Artefact;

public class Valkyrie extends Hero{

    public Valkyrie(String name, Integer level, Integer experience, Integer attack, Integer defence, Integer hitPoints, Artefact artefacts) {
        super(name, "Valkyrie", level, experience, attack, defence , hitPoints, artefacts);
    }
}
