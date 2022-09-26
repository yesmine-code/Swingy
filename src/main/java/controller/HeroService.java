package controller;

import dao.HeroDao;
import exceptions.ArtefactNotFoundException;
import exceptions.FileNotFoundException;
import exceptions.HeroClassNotFoundException;
import model.artefacts.Artefact;
import model.hero.Hero;
import model.hero.HeroEnum;
import model.hero.HeroFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HeroService {
    private ArtefactService artefactService;
    private HeroDao heroDao;

    public HeroService(HeroDao heroDao) {
        this.artefactService = new ArtefactService();
        this.heroDao = heroDao;
    }

    public Hero createHero(String heroClass, String name, String artefact) throws HeroClassNotFoundException, ArtefactNotFoundException {
        return (HeroFactory.createHero(name, heroClass, artefactService.createArtefact(artefact)));
    }

    public void addArtefactToHero(Hero hero, Artefact artefact) {
        if (hero != null)
            hero.setArtefact(artefact);
    }

    public List<Hero> getAllHeroes() throws HeroClassNotFoundException, FileNotFoundException, IOException, ArtefactNotFoundException {
        return heroDao.getAllHeroes();
    }

    public void saveHero(Hero hero) throws FileNotFoundException {
        heroDao.saveHero(hero);
    }
}
