package com.projects.model.hero;
import com.projects.exceptions.HeroClassNotFoundException;
import com.projects.model.artefacts.Artefact;

public class HeroFactory {
    public static Hero createHero(Integer id, String name, String heroClass, Integer experience, Artefact artefact) throws HeroClassNotFoundException {
        if (HeroEnum.CHEVALIER.toString().equalsIgnoreCase(heroClass))
            return new Chevalier(id, name, experience, HeroEnum.CHEVALIER.getAttack(),
                    HeroEnum.CHEVALIER.getDefence(), HeroEnum.CHEVALIER.getHitPoints(), artefact);
        else if (HeroEnum.DRAGON.toString().equalsIgnoreCase(heroClass))
            return  new Dragon(id, name, experience, HeroEnum.DRAGON.getAttack(),
                    HeroEnum.DRAGON.getDefence(), HeroEnum.DRAGON.getHitPoints(), artefact);
        else if (HeroEnum.PEKKA.toString().equalsIgnoreCase(heroClass))
            return  new Pekka(id, name, experience, HeroEnum.PEKKA.getAttack(),
                    HeroEnum.PEKKA.getDefence(), HeroEnum.PEKKA.getHitPoints(), artefact);
        else if (HeroEnum.PRINCE.toString().equalsIgnoreCase(heroClass))
            return  new Prince(id, name, experience, HeroEnum.PRINCE.getAttack(),
                    HeroEnum.PRINCE.getDefence(), HeroEnum.PRINCE.getHitPoints(), artefact);
        else if (HeroEnum.SORCIER.toString().equalsIgnoreCase(heroClass))
            return  new Sorcier(id, name, experience, HeroEnum.SORCIER.getAttack(),
                    HeroEnum.SORCIER.getDefence(), HeroEnum.SORCIER.getHitPoints(), artefact);
        else if (HeroEnum.VOLEUSE.toString().equalsIgnoreCase(heroClass))
            return  new Voleuse(id, name, experience, HeroEnum.VOLEUSE.getAttack(),
                    HeroEnum.VOLEUSE.getDefence(), HeroEnum.VOLEUSE.getHitPoints(), artefact);
        else if (HeroEnum.VALKYRIE.toString().equalsIgnoreCase(heroClass))
            return  new Valkyrie(id, name, experience, HeroEnum.VALKYRIE.getAttack(),
                    HeroEnum.VALKYRIE.getDefence(), HeroEnum.VALKYRIE.getHitPoints(), artefact);
        else{
            throw new HeroClassNotFoundException(heroClass);
        }

    }
}
