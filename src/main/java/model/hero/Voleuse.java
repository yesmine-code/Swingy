package model.hero;

import model.artefacts.Artefact;

public class Voleuse extends Hero{

    public Voleuse(Integer id, String name, Integer experience, Integer attack, Integer defence, Integer hitPoints, Artefact artefacts) {
        super(id, name, "Voleuse", experience, attack, defence , hitPoints, artefacts);
    }
}
