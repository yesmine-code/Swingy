package org.yesmine.controller;

import org.yesmine.dao.HeroDao;
import org.yesmine.exceptions.ArtefactNotFoundException;
import org.yesmine.exceptions.FileNotFoundException;
import org.yesmine.exceptions.HeroClassNotFoundException;
import org.yesmine.model.artefacts.Artefact;
import org.yesmine.model.hero.Hero;
import org.yesmine.model.hero.HeroFactory;

import java.io.IOException;
import java.util.List;

public class HeroService {
    private ArtefactService artefactService;
    private HeroDao heroDao;

    public HeroService(HeroDao heroDao) {
        this.artefactService = new ArtefactService();
        this.heroDao = heroDao;
    }

    public Hero createHero(Integer id, String heroClass, String name, String artefact, int xp) throws HeroClassNotFoundException, ArtefactNotFoundException, FileNotFoundException, IOException {
        if (id == -1) //create new hero
            return (HeroFactory.createHero(heroDao.getNextId(), name, heroClass, xp, artefactService.createArtefact(artefact)));
        else //select
            return (HeroFactory.createHero(id, name, heroClass, xp, artefactService.createArtefact(artefact)));

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

    public Integer computeMapSize(Hero hero){
        return hero.computeMapSize();
    }





}
