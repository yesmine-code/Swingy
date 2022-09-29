package org.yesmine.model.hero;

import org.yesmine.model.artefacts.Artefact;

public class Prince extends Hero{
    public Prince(Integer id, String name, Integer experience, Integer attack, Integer defence, Integer hitPoints, Artefact artefacts) {
        super(id, name, "Prince", experience, attack, defence , hitPoints, artefacts);
    }
}
