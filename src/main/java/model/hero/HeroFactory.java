package model.hero;
import exceptions.HeroClassNotFoundException;
import model.artefacts.Artefact;

public class HeroFactory {
    public static Hero createHero(String name, String heroClass, Artefact artefact) throws HeroClassNotFoundException {
        if (HeroEnum.CHEVALIER.toString().equalsIgnoreCase(heroClass))
            return new Chevalier(name,1, 1000, HeroEnum.CHEVALIER.getAttack(),
                    HeroEnum.CHEVALIER.getDefence(), HeroEnum.CHEVALIER.getHitPoints(), artefact);
        else if (HeroEnum.DRAGON.toString().equalsIgnoreCase(heroClass))
            return  new Dragon(name, 1, 1000, HeroEnum.DRAGON.getAttack(),
                    HeroEnum.DRAGON.getDefence(), HeroEnum.DRAGON.getHitPoints(), artefact);
        else if (HeroEnum.PEKKA.toString().equalsIgnoreCase(heroClass))
            return  new Pekka(name, 1, 1000, HeroEnum.PEKKA.getAttack(),
                    HeroEnum.PEKKA.getDefence(), HeroEnum.PEKKA.getHitPoints(), artefact);
        else if (HeroEnum.PRINCE.toString().equalsIgnoreCase(heroClass))
            return  new Prince(name, 1, 1000, HeroEnum.PRINCE.getAttack(),
                    HeroEnum.PRINCE.getDefence(), HeroEnum.PRINCE.getHitPoints(), artefact);
        else if (HeroEnum.SORCIER.toString().equalsIgnoreCase(heroClass))
            return  new Sorcier(name, 1, 1000, HeroEnum.SORCIER.getAttack(),
                    HeroEnum.SORCIER.getDefence(), HeroEnum.SORCIER.getHitPoints(), artefact);
        else if (HeroEnum.VOLEUSE.toString().equalsIgnoreCase(heroClass))
            return  new Voleuse(name, 1, 1000, HeroEnum.VOLEUSE.getAttack(),
                    HeroEnum.VOLEUSE.getDefence(), HeroEnum.VOLEUSE.getHitPoints(), artefact);
        else if (HeroEnum.VALKYRIE.toString().equalsIgnoreCase(heroClass))
            return  new Valkyrie(name, 1, 1000, HeroEnum.VALKYRIE.getAttack(),
                    HeroEnum.VALKYRIE.getDefence(), HeroEnum.VALKYRIE.getHitPoints(), artefact);
        else{
            throw new HeroClassNotFoundException(heroClass);
        }

    }
}
