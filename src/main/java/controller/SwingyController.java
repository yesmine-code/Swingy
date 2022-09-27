package controller;

import dao.FileDao;
import dao.HeroDao;
import exceptions.ArtefactNotFoundException;
import exceptions.FileNotFoundException;
import exceptions.HeroClassNotFoundException;
import exceptions.VillainClassNotFoundException;
import model.hero.Hero;

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

    public void initGame(String name, String heroClass, String artefact) throws HeroClassNotFoundException, VillainClassNotFoundException, ArtefactNotFoundException {
        Hero hero = heroService.createHero(heroClass, name, artefact);
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
}
