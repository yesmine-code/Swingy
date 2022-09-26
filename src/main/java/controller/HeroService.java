package controller;

import exceptions.ArtefactNotFoundException;
import exceptions.HeroClassNotFoundException;
import model.artefacts.Artefact;
import model.hero.Hero;
import model.hero.HeroEnum;
import model.hero.HeroFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HeroService {
    private ArtefactService artefactService;

    public HeroService(){
        this.artefactService = new ArtefactService();
    }

    public Hero createHero(String heroClass, String name, String artefact) throws HeroClassNotFoundException, ArtefactNotFoundException {
        return (HeroFactory.createHero(name, heroClass, artefactService.createArtefact(artefact)));
    }


    public List<String> getHeroClasses() {
        return Arrays.stream(HeroEnum.values()).map(Enum::toString).collect(Collectors.toList());
    }

    public void addArtefactToHero(Hero hero, Artefact artefact){
        if (hero != null)
            hero.setArtefact(artefact);
    }
}
