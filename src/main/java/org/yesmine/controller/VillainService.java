package org.yesmine.controller;

import org.yesmine.exceptions.VillainClassNotFoundException;
import org.yesmine.model.artefacts.Artefact;
import org.yesmine.model.villain.Villain;
import org.yesmine.model.villain.VillainEnum;
import org.yesmine.model.villain.VillainFactory;

import java.util.Random;

public class VillainService {
    public Villain createVillain(String name) throws VillainClassNotFoundException {
        return VillainFactory.getVillain(name);
    }
    public void addArtefactToVillain(Villain villain, Artefact artefact){
        if (villain != null)
            villain.setArtefact(artefact);
    }

    public String getRandomVillainName(){
        Random rand = new Random();
        Integer i = rand.nextInt(3);
        return VillainEnum.values()[i].getName();
    }
}
