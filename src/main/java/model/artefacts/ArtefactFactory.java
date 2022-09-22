package model.artefacts;

import exceptions.ArtefactNotFoundException;

public class ArtefactFactory {
    public Artefact getArtefact(String name) throws ArtefactNotFoundException {
        if (ArtefactEnum.GUNWEAPON.getName().equalsIgnoreCase(name))
            return new Weapon(name, ArtefactEnum.GUNWEAPON.getPower());
        if (ArtefactEnum.GUNWEAPON.getName().equalsIgnoreCase(name))
            return new Weapon(name, ArtefactEnum.GUNWEAPON.getPower());
        if (ArtefactEnum.GUNWEAPON.getName().equalsIgnoreCase(name))
            return new Weapon(name, ArtefactEnum.GUNWEAPON.getPower());
        throw new ArtefactNotFoundException(name);
    }
}
