package controller;

import exceptions.HeroClassNotFoundException;
import exceptions.VillainClassNotFoundException;
import model.hero.Hero;

public class SwingyController {
    private HeroService heroService;
    private MapService mapService;
    private VillainService villainService;

    public SwingyController(){
        heroService = new HeroService();
        villainService = new VillainService();
        mapService = new MapService(villainService);
    }

    public void initGame(String name, String heroClass) throws HeroClassNotFoundException, VillainClassNotFoundException {
        Hero hero = heroService.createHero(heroClass, name);
        mapService.initMap(hero);
        mapService.putHeroInitialPosition();

    }
}
