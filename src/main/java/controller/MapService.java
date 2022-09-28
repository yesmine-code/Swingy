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
        hero.computeLevel();
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
        if ("R".equalsIgnoreCase(response) && hero.getPosition().getX() + 1 < mapSize) {
            hero.setPreviousPosition(hero.getPosition());
            hero.getPosition().setX(hero.getPosition().getX() + 1);
        }
        else if ("L".equalsIgnoreCase(response) && hero.getPosition().getX() - 1 >= 0) {
            hero.setPreviousPosition(hero.getPosition());
            hero.getPosition().setX(hero.getPosition().getX() - 1);
        }
        else if ("U".equalsIgnoreCase(response) && hero.getPosition().getY() - 1 >= 0) {
            hero.setPreviousPosition(hero.getPosition());
            hero.getPosition().setY(hero.getPosition().getY() - 1);
        }
        else if ("D".equalsIgnoreCase(response) && hero.getPosition().getY() + 1 < mapSize) {
            hero.setPreviousPosition(hero.getPosition());
            hero.getPosition().setY(hero.getPosition().getY() + 1);
        }
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
    public Villain villainExist(){
        return map[hero.getPosition().getY()][hero.getPosition().getX()];
    }

    public boolean heroWinsFight(Villain villain){
        Integer heroPower = hero.getAttack() * 2 + hero.getDefence()  * 3 + hero.getHitPoints() * 2 +
                hero.getArtefact().getHitPointsAffect()+ hero.getArtefact().getDefenceAffect() + hero.getArtefact().getAttackAffect();
        Integer villainPower = villain.getPower() * 7 + villain.getArtefact().getDefenceAffect() +
                villain.getArtefact().getAttackAffect() + villain.getArtefact().getHitPointsAffect();
        Random rand = new Random();
        double r1 = rand.nextDouble() + 1;
        double r2 = rand.nextDouble() + 1;
        return  (heroPower * r1 > villainPower * r2);
    }

    public boolean runningSimulator(){
        Random rand = new Random();
        double r1 = rand.nextDouble();
        return r1 < 0.5;

    }

}
