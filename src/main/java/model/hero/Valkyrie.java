package model.hero;

import model.artefacts.Artefact;

public class Valkyrie extends Hero{

    public Valkyrie(Integer id, String name, Integer experience, Integer attack, Integer defence, Integer hitPoints, Artefact artefacts) {
        super(id, name, "Valkyrie", experience, attack, defence , hitPoints, artefacts);
    }
}
