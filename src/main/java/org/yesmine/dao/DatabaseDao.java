package org.yesmine.dao;

import org.hibernate.Session;
import org.yesmine.dao.entities.HeroEntity;
import org.yesmine.exceptions.ArtefactNotFoundException;
import org.yesmine.exceptions.FileNotFoundException;
import org.yesmine.exceptions.HeroClassNotFoundException;
import org.yesmine.model.hero.Hero;
import org.yesmine.utility.HibernateUtility;

import java.math.BigInteger;
import java.util.List;

public class DatabaseDao implements HeroDao {
    @Override
    public void saveHero(Hero hero) throws FileNotFoundException {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        HeroEntity heroEntity = HeroMapping.mapHeroToHeroEntity(hero);
        session.save(heroEntity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Hero> getAllHeroes() throws HeroClassNotFoundException, ArtefactNotFoundException {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        List<HeroEntity> heroEntities = session.createQuery("SELECT a FROM HeroEntity a", HeroEntity.class).getResultList();
        List<Hero> heroes = HeroMapping.mapAllHeroEntitiesToHeroes(heroEntities);
        session.close();
        return heroes;
    }

    @Override
    public Integer getNextId() {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        BigInteger maxId = (BigInteger) session.createSQLQuery("SELECT max(id) from heroes").uniqueResult();
        int lastId = maxId == null ? 0 : maxId.intValue() ;
        session.close();
        return lastId + 1;
    }

    @Override
    public void updateHero(Hero hero) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(HeroMapping.mapHeroToHeroEntity(hero));
        session.getTransaction().commit();
        HibernateUtility.shutdown();
    }

    @Override
    public boolean previousHeroExist() {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        long rows = (long) session.createQuery("select count(h.id) from HeroEntity h").iterate().next();
        session.close();
        return rows > 0;
    }

    @Override
    public void makeEmpty() {
    }
}
