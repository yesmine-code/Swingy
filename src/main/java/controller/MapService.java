package controller;

import exceptions.VillainClassNotFoundException;
import model.hero.Hero;
import model.hero.Position;
import model.villain.Villain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapService {
    private Hero hero;
    private Villain[][] map;
    private VillainService villainService;

    public MapService(VillainService villainService) {
        this.villainService = villainService;
    }

    public void initMap(Hero hero) throws VillainClassNotFoundException {
        this.hero = hero;
        Integer size = hero.computeMapSize();
        map = new Villain[size][size];
        Integer i = 0;
        Integer j = 0;
        Random random = new Random();
        while(i < size){
            while(j < size){
                if ((j != size / 2 || i != size / 2) && random.nextBoolean())
                    map[i][j] = villainService.createVillain(villainService.getRandomVillainName());
                j++;
            }
            i++;
        }
    }
    public void putHeroInitialPosition(){
        Position position = new Position();
        position.setX(map.length / 2);
        position.setY(map.length / 2);
        hero.setPosition(position);
    }
}
