package model.hero;

import model.artefacts.Artefact;

public class Voleuse extends Hero{

    public Voleuse(String name, Integer level, Integer experience, Integer attack, Integer defence, Integer hitPoints, Artefact artefacts) {
        super(name, "Voleuse", level, experience, attack, defence , hitPoints, artefacts);
    }
}
