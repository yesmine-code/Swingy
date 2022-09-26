package dao;

import exceptions.ArtefactNotFoundException;
import exceptions.FileNotFoundException;
import exceptions.HeroClassNotFoundException;
import model.artefacts.ArtefactFactory;
import model.hero.Hero;
import model.hero.HeroEnum;
import model.hero.HeroFactory;
import utility.FileManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static utility.FileManager.file;
import static utility.FileManager.getFile;

public class FileDao implements HeroDao{

    FileManager fileManager;
    ArtefactFactory artefactFactory;
    HeroFactory heroFactory;

    public FileDao() throws FileNotFoundException {
        this.fileManager = getFile("PreviousHeroes");
        this.heroFactory = new HeroFactory();
        this.artefactFactory = new ArtefactFactory();
    }

    @Override
    public  void saveHero(Hero hero) throws FileNotFoundException {
        FileManager.writeIntoFile(hero.getName() + " " + hero.getHeroClass() + " " + hero.getAttack()
                + " " + hero.getDefence() + " " + hero.getHitPoints() + " " + hero.getArtefact());

    }

    @Override
    public List<Hero> getAllHeroes() throws FileNotFoundException, IOException, HeroClassNotFoundException, ArtefactNotFoundException {
            getFile(file.getName());
            BufferedReader br = new BufferedReader(new FileReader(file.getName()));
            String line;
            List<Hero> heroes = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String str[] = line.split(" ");
                try {
                    heroes.add(HeroFactory.createHero(str[0], str[1], ArtefactFactory.getArtefact(str[str.length - 1])));
                }
                catch (HeroClassNotFoundException  | ArtefactNotFoundException | ArrayIndexOutOfBoundsException e){
                    return Collections.emptyList();
                }
            }
        return heroes;
    }
}
