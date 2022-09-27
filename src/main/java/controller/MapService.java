package controller;

import exceptions.VillainClassNotFoundException;
import model.hero.Hero;
import model.hero.Position;
import model.villain.Villain;

import java.util.Random;

public class MapService {
    private Hero hero;
    private Villain[][] map;
    private VillainService villainService;
    private Integer mapSize;

    public MapService(VillainService villainService) {
        this.villainService = villainService;
    }

    public void initMap(Hero hero) throws VillainClassNotFoundException {
        this.hero = hero;
        mapSize = hero.computeMapSize();
        map = new Villain[mapSize][mapSize];
        Integer i = 0;
        Integer j = 0;
        Random random = new Random();
        while (i < mapSize) {
            while (j < mapSize) {
                if ((j != mapSize / 2 || i != mapSize / 2) && random.nextBoolean())
                    map[i][j] = villainService.createVillain(villainService.getRandomVillainName());
                j++;
            }
            i++;
        }
    }

    public void putHeroInitialPosition() {
        Position position = new Position();
        position.setX(map.length / 2);
        position.setY(map.length / 2);
        hero.setPosition(position);
    }

    public void setNewPosition(String response) {
        if ("R".equalsIgnoreCase(response) && hero.getPosition().getX() + 1 < mapSize)
            hero.getPosition().setX(hero.getPosition().getX() + 1);
        else if ("L".equalsIgnoreCase(response) && hero.getPosition().getX() - 1 >= 0)
            hero.getPosition().setX(hero.getPosition().getX() - 1);
        else if ("U".equalsIgnoreCase(response) && hero.getPosition().getY() - 1 >= 0)
            hero.getPosition().setY(hero.getPosition().getY() - 1);
        else if ("D".equalsIgnoreCase(response) && hero.getPosition().getY() + 1 < mapSize)
            hero.getPosition().setY(hero.getPosition().getY() + 1);
    }
    public boolean reachBorder(){
        if (hero.getPosition().getX() == 0 || hero.getPosition().getY() == 0 ||
                hero.getPosition().getX() == mapSize - 1 || hero.getPosition().getY() == mapSize - 1)
            return true;
        return false;
    }

    public Hero getHero() {
        return hero;
    }
}
