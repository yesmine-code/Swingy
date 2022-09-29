package com.projects.controller;

import com.projects.dao.HeroDao;
import com.projects.exceptions.ArtefactNotFoundException;
import com.projects.exceptions.FileNotFoundException;
import com.projects.exceptions.HeroClassNotFoundException;
import com.projects.model.artefacts.Artefact;
import com.projects.model.hero.Hero;
import com.projects.model.hero.HeroFactory;

import java.io.IOException;
import java.util.List;

public class HeroService {
    private ArtefactService artefactService;
    private HeroDao heroDao;

    public HeroService(HeroDao heroDao) {
        this.artefactService = new ArtefactService();
        this.heroDao = heroDao;
    }

    public Hero createHero(Integer id, String heroClass, String name, String artefact) throws HeroClassNotFoundException, ArtefactNotFoundException, FileNotFoundException, IOException {
        if (id == -1)
            return (HeroFactory.createHero(heroDao.getNextId(), name, heroClass, 1000, artefactService.createArtefact(artefact)));
        else
            return (HeroFactory.createHero(id, name, heroClass, 1000, artefactService.createArtefact(artefact)));

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
