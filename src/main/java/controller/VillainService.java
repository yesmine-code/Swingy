package controller;

import exceptions.VillainClassNotFoundException;
import model.artefacts.Artefact;
import model.villain.Villain;
import model.villain.VillainEnum;
import model.villain.VillainFactory;

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
