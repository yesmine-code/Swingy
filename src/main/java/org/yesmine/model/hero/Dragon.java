package org.yesmine.model.hero;

import org.yesmine.model.artefacts.Artefact;

public class Dragon extends Hero{
    public Dragon(Integer id, String name, Integer experience, Integer attack, Integer defence, Integer hitPoints, Artefact artefacts) {
        super(id, name, "Dragon", experience, attack, defence , hitPoints, artefacts);
    }
}
