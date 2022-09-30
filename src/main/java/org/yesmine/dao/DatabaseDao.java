package org.yesmine.dao;

import org.hibernate.Session;
import org.yesmine.dao.entities.HeroEntity;
import org.yesmine.exceptions.ArtefactNotFoundException;
import org.yesmine.exceptions.FileNotFoundException;
import org.yesmine.exceptions.HeroClassNotFoundException;
import org.yesmine.model.hero.Hero;
import org.yesmine.utility.HibernateUtility;

import java.io.IOException;
import java.util.List;

public class DatabaseDao implements HeroDao {
    @Override
    public void saveHero(Hero hero) throws FileNotFoundException {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        HeroEntity heroEntity = HeroMapping.mapHeroToHeroEntity(hero);
        session.save(heroEntity);
        session.getTransaction().commit();
        HibernateUtility.shutdown();
    }

    @Override
    public List<Hero> getAllHeroes() throws HeroClassNotFoundException, ArtefactNotFoundException {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        List<HeroEntity> heroEntities = session.createQuery("SELECT a FROM HeroEntity a", HeroEntity.class).getResultList();
        List<Hero> heroes = HeroMapping.mapAllHeroEntitiesToHeroes(heroEntities);
        session.getTransaction().commit();
        HibernateUtility.shutdown();
        return heroes;
    }

    @Override
    public Integer getNextId() throws FileNotFoundException, IOException {
        return null;
    }

    @Override
    public void updateHero(Hero hero) throws FileNotFoundException, IOException {

    }

    @Override
    public boolean previousHeroExist() {
        return false;
    }

    @Override
    public void makeEmpty() throws java.io.FileNotFoundException {

    }
}
