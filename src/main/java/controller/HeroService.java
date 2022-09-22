package controller;

import exceptions.HeroClassNotFoundException;
import model.artefacts.Artefact;
import model.hero.Hero;
import model.hero.HeroEnum;
import model.hero.HeroFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HeroService {

    public Hero createHero(String heroClass, String name) throws HeroClassNotFoundException {
        return (HeroFactory.createHero(name, heroClass));
    }

    public List<Hero> getCreatedHeroes() {
        //todo
        return null;
    }

    public void saveHero(Hero hero) {
        //todo
    }

    public List<String> getHeroClasses() {
        return Arrays.stream(HeroEnum.values()).map(Enum::toString).collect(Collectors.toList());
    }

    public void addArtefactToHero(Hero hero, Artefact artefact){
        if (hero != null)
            hero.setArtefact(artefact);
    }
}
