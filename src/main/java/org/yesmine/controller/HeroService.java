package org.yesmine.controller;

import org.yesmine.dao.HeroDao;
import org.yesmine.exceptions.ArtefactNotFoundException;
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

    public Hero createHero(Integer id, String heroClass, String name, String artefact, int xp) throws IOException {
        try {
            if (id == -1) //create new hero
                return (HeroFactory.createHero(heroDao.getNextId(), name, heroClass, xp, artefactService.createArtefact(artefact)));
            else //select
                return (HeroFactory.createHero(id, name, heroClass, xp, artefactService.createArtefact(artefact)));
        }catch (HeroClassNotFoundException | ArtefactNotFoundException e){
            return null;
        }
    }

    public void addArtefactToHero(Hero hero, Artefact artefact) {
        if (hero != null)
            hero.setArtefact(artefact);
    }

    public List<Hero> getAllHeroes() throws HeroClassNotFoundException, IOException, ArtefactNotFoundException {
        return heroDao.getAllHeroes();
    }

    public void saveHero(Hero hero) throws IOException {
        heroDao.saveHero(hero);
    }

    public Integer computeMapSize(Hero hero){
        return hero.computeMapSize();
    }





}
