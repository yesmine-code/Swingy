package com.projects.dao;

import com.projects.exceptions.ArtefactNotFoundException;
import com.projects.exceptions.FileNotFoundException;
import com.projects.exceptions.HeroClassNotFoundException;
import com.projects.model.hero.Hero;

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
