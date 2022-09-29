package org.yesmine.model.artefacts;

import org.yesmine.exceptions.ArtefactNotFoundException;

public class ArtefactFactory {
    public static Artefact getArtefact(String name) throws ArtefactNotFoundException {
        if (ArtefactEnum.GUNWEAPON.getName().equalsIgnoreCase(name))
            return new Weapon(name, ArtefactEnum.GUNWEAPON.getPower());
        if (ArtefactEnum.KNIFEWEAPON.getName().equalsIgnoreCase(name))
            return new Weapon(name, ArtefactEnum.KNIFEWEAPON.getPower());
        if (ArtefactEnum.FIREWEAPON.getName().equalsIgnoreCase(name))
            return new Weapon(name, ArtefactEnum.FIREWEAPON.getPower());
        if (ArtefactEnum.BREASTARMOR.getName().equalsIgnoreCase(name))
            return new Armor(name, ArtefactEnum.BREASTARMOR.getPower());
        if (ArtefactEnum.FACEARMOR.getName().equalsIgnoreCase(name))
            return new Armor(name, ArtefactEnum.FACEARMOR.getPower());
        if (ArtefactEnum.HEADARMOR.getName().equalsIgnoreCase(name))
            return new Armor(name, ArtefactEnum.HEADARMOR.getPower());
        if (ArtefactEnum.FLATHELM.getName().equalsIgnoreCase(name))
            return new Helm(name, ArtefactEnum.FLATHELM.getPower());
        if (ArtefactEnum.NASALHELM.getName().equalsIgnoreCase(name))
            return new Helm(name, ArtefactEnum.NASALHELM.getPower());
        if (ArtefactEnum.HOLEFACEHELM.getName().equalsIgnoreCase(name))
            return new Helm(name, ArtefactEnum.HOLEFACEHELM.getPower());
        throw new ArtefactNotFoundException(name);
    }
}
