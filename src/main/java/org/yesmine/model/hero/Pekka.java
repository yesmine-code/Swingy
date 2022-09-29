package org.yesmine.model.hero;

import org.yesmine.model.artefacts.Artefact;

public class Pekka extends Hero{
    public Pekka(Integer id, String name, Integer experience, Integer attack, Integer defence, Integer hitPoints, Artefact artefacts) {
        super(id, name, "Pekka", experience, attack, defence , hitPoints, artefacts);
    }
}
