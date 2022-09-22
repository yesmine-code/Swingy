package model.hero;

import model.artefacts.Artefact;

public class Prince extends Hero{
    public Prince(String name, Integer level, Integer experience, Integer attack, Integer defence, Integer hitPoints, Artefact artefacts) {
        super(name, "Prince", level, experience, attack, defence , hitPoints, artefacts);
    }
}
