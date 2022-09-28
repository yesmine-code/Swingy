package dao;

import exceptions.ArtefactNotFoundException;
import exceptions.FileNotFoundException;
import exceptions.HeroClassNotFoundException;
import model.hero.Hero;

import java.io.IOException;
import java.util.List;

public interface HeroDao {
    public  void saveHero(Hero hero) throws FileNotFoundException;
    public List<Hero> getAllHeroes() throws FileNotFoundException, IOException, HeroClassNotFoundException, ArtefactNotFoundException;
    public Integer getNextId() throws FileNotFoundException, IOException;
    public void updateHero(Hero hero) throws FileNotFoundException, IOException;
    public boolean previousHeroExist();
    public void makeEmpty() throws java.io.FileNotFoundException;
}
