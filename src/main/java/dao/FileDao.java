package dao;

import exceptions.ArtefactNotFoundException;
import exceptions.FileNotFoundException;
import exceptions.HeroClassNotFoundException;
import model.artefacts.ArtefactFactory;
import model.hero.Hero;
import model.hero.HeroFactory;
import utility.FileManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static utility.FileManager.file;
import static utility.FileManager.getFile;

public class FileDao implements HeroDao {

    FileManager fileManager;
    ArtefactFactory artefactFactory;
    HeroFactory heroFactory;

    public FileDao() throws FileNotFoundException {
        this.fileManager = getFile("PreviousHeroes");
        this.heroFactory = new HeroFactory();
        this.artefactFactory = new ArtefactFactory();
    }

    @Override
    public void saveHero(Hero hero) throws FileNotFoundException {
        FileManager.writeIntoFile(hero.getName() + " " + hero.getHeroClass()
                + " " + hero.getExperience() + " " + hero.getArtefact());

    }

    @Override
    public List<Hero> getAllHeroes() throws FileNotFoundException, IOException {
        getFile(file.getName());
        BufferedReader br = new BufferedReader(new FileReader(file.getName()));
        String line;
        List<Hero> heroes = new ArrayList<>();
        Integer i = 0;
        while ((line = br.readLine()) != null) {
            String str[] = line.split(" ");
            try {
                heroes.add(HeroFactory.createHero(i, str[0], str[1], Integer.parseInt(str[2]), ArtefactFactory.getArtefact(str[str.length - 1])));
                i++;
            } catch (HeroClassNotFoundException | ArtefactNotFoundException | ArrayIndexOutOfBoundsException e) {
                return Collections.emptyList();
            }
        }
        return heroes;
    }
}
