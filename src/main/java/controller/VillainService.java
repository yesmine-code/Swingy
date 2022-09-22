package controller;

import exceptions.VillainClassNotFoundException;
import model.artefacts.Artefact;
import model.villain.Villain;
import model.villain.VillainFactory;

public class VillainService {
    public Villain createVillain(String name) throws VillainClassNotFoundException {
        return VillainFactory.getVillain(name);
    }
    public void addArtefactToVillain(Villain villain, Artefact artefact){
        if (villain != null)
            villain.setArtefact(artefact);
    }
}
