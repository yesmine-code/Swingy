package model.villain;

import exceptions.VillainClassNotFoundException;

public class VillainFactory {
    public Villain getVillain(String name) throws VillainClassNotFoundException {
        if (VillainEnum.BARBARES.getName().equals(name))
            return new Barbares(name, VillainEnum.BARBARES.getPower(), null);
        if (VillainEnum.SQUELETTES.getName().equals(name))
            return new Squelettes(name, VillainEnum.SQUELETTES.getPower(), null);
        if (VillainEnum.COCHONS.getName().equals(name))
            return new Cochons(name, VillainEnum.COCHONS.getPower(), null);
        throw new VillainClassNotFoundException(name);
    }
}
