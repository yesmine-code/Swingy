package model.hero;

import model.artefacts.Artefact;

public class Dragon extends Hero{
    public Dragon(String name, Integer level, Integer experience, Integer attack, Integer defence, Integer hitPoints, Artefact artefacts) {
        super(name, "Dragon", level, experience, attack, defence , hitPoints, artefacts);
    }
}
