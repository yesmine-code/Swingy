package org.yesmine.dao;

import org.yesmine.dao.entities.HeroEntity;
import org.yesmine.exceptions.ArtefactNotFoundException;
import org.yesmine.exceptions.HeroClassNotFoundException;
import org.yesmine.model.artefacts.ArtefactFactory;
import org.yesmine.model.hero.Hero;
import org.yesmine.model.hero.HeroFactory;

import java.util.ArrayList;
import java.util.List;

public class HeroMapping {
    public static HeroEntity mapHeroToHeroEntity(Hero hero) {
        HeroEntity heroEntity = new HeroEntity();
        heroEntity.setId(hero.getId());
        heroEntity.setHeroName(hero.getName());
        heroEntity.setHeroClass(hero.getHeroClass());
        heroEntity.setXp(hero.getExperience());
        heroEntity.setArtefact(hero.getArtefact().getName());
        return heroEntity;

    }

    public static Hero mapHeroEntityToHero(HeroEntity heroEntity) throws ArtefactNotFoundException, HeroClassNotFoundException {
        return HeroFactory.createHero(heroEntity.getId(), heroEntity.getHeroName(), heroEntity.getHeroClass(),
                heroEntity.getXp(), ArtefactFactory.getArtefact(heroEntity.getArtefact()));

    }

    public static List<Hero> mapAllHeroEntitiesToHeroes(List<HeroEntity> heroEntities) throws HeroClassNotFoundException, ArtefactNotFoundException {
        List<Hero> heroes = new ArrayList<>();
        for (HeroEntity heroEntity :heroEntities) {
            heroes.add(mapHeroEntityToHero(heroEntity));
        }
        return heroes;
    }
}
