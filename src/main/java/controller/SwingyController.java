package controller;

import exceptions.ArtefactNotFoundException;
import exceptions.HeroClassNotFoundException;
import exceptions.VillainClassNotFoundException;
import model.hero.Hero;

public class SwingyController {
    private HeroService heroService;
    private MapService mapService;
    private VillainService villainService;

    private ArtefactService artefactService;

    public SwingyController(){
        heroService = new HeroService();
        villainService = new VillainService();
        mapService = new MapService(villainService);
        artefactService = new ArtefactService();
    }

    public void initGame(String name, String heroClass, String artefact) throws HeroClassNotFoundException, VillainClassNotFoundException, ArtefactNotFoundException {
        Hero hero = heroService.createHero(heroClass, name, artefact);
        mapService.initMap(hero);
        mapService.putHeroInitialPosition();

    }

    public HeroService getHeroService() {
        return heroService;
    }

    public MapService getMapService() {
        return mapService;
    }

    public VillainService getVillainService() {
        return villainService;
    }

    public ArtefactService getArtefactService() {
        return artefactService;
    }
}
