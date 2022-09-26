package dao;

import exceptions.ArtefactNotFoundException;
import exceptions.FileNotFoundException;
import exceptions.HeroClassNotFoundException;
import model.hero.Hero;

import java.io.IOException;
import java.util.List;

public interface HeroDao {
    public  void saveHero() throws FileNotFoundException;
    public List<Hero> getAllHeroes() throws FileNotFoundException, IOException, HeroClassNotFoundException, ArtefactNotFoundException;
}
