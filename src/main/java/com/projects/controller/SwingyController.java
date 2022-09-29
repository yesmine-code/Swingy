package com.projects.controller;

import com.projects.dao.FileDao;
import com.projects.dao.HeroDao;
import com.projects.exceptions.ArtefactNotFoundException;
import com.projects.exceptions.FileNotFoundException;
import com.projects.exceptions.HeroClassNotFoundException;
import com.projects.exceptions.VillainClassNotFoundException;
import com.projects.model.hero.Hero;
import com.projects.model.villain.Villain;

import java.io.IOException;
import java.util.List;

public class SwingyController {
    private HeroService heroService;
    private MapService mapService;
    private VillainService villainService;

    private ArtefactService artefactService;
    private HeroDao heroDao;

    public SwingyController() throws FileNotFoundException {
        heroDao = new FileDao();
        heroService = new HeroService(heroDao);
        villainService = new VillainService();
        mapService = new MapService(villainService);
        artefactService = new ArtefactService();
    }

    public void initGame(Integer id, String name, String heroClass, String artefact, int xp) throws HeroClassNotFoundException, VillainClassNotFoundException, ArtefactNotFoundException, FileNotFoundException, IOException {
        Hero hero = heroService.createHero(id, heroClass, name, artefact, xp);
        mapService.initMap(hero);
        mapService.putHeroInitialPosition();

    }


    public List<Hero> getAllHeroes() throws HeroClassNotFoundException, FileNotFoundException, IOException, ArtefactNotFoundException {
        return heroService.getAllHeroes();
    }

    public void saveHero(Hero hero) throws FileNotFoundException {
        heroService.saveHero(hero);
    }

    public Integer computeMapSize(Hero hero) {
        return heroService.computeMapSize(hero);
    }

    public void setNewPosition(String response){
        mapService.setNewPosition(response);
    }

    public boolean reachBorder(){
        return mapService.reachBorder();
    }

    public Hero getHero(){
        return mapService.getHero();
    }

    public void updateHero() throws FileNotFoundException, IOException {
        Hero hero = mapService.getHero();
        heroDao.updateHero(hero);
    }

    public boolean previousHeroExist(){
        return heroDao.previousHeroExist();
    }
    public void makeEmpty() throws java.io.FileNotFoundException {
        heroDao.makeEmpty();
    }
    public Villain villainExist(){
        return mapService.villainExist();
    }

    public boolean heroWinsFight(Villain villain){
        return mapService.heroWinsFight(villain);
    }

    public boolean runnigSimulation(){
        return mapService.runningSimulator();
    }

    public void returnToPreviousPosition(){
        mapService.getHero().setPosition(getHero().getPreviousPosition());
    }

    public void  changeArtefact(Villain villain){
        mapService.changeArtefact(villain);
    }

    public void setNewXp(Villain villain){
        mapService.setNewXp(villain);
    }


}
