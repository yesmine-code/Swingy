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
import java.io.FileWriter;
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
        FileManager.writeIntoFile(hero.getId() + " " + hero.getName() + " " + hero.getHeroClass()
                + " " + hero.getExperience() + " " + hero.getArtefact());

    }

    @Override
    public List<Hero> getAllHeroes() throws FileNotFoundException, IOException {
        getFile(file.getName());
        BufferedReader br = new BufferedReader(new FileReader(file.getName()));
        String line;
        List<Hero> heroes = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            String str[] = line.split(" ");
            try {
                heroes.add(HeroFactory.createHero(Integer.parseInt(str[0]), str[1], str[2], Integer.parseInt(str[3]), ArtefactFactory.getArtefact(str[str.length - 1])));
            } catch (HeroClassNotFoundException | ArtefactNotFoundException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
                return Collections.emptyList();
            }
        }
        return heroes;
    }
    @Override
    public Integer getNextId() throws FileNotFoundException, IOException {
        try {
            Integer i = 0;
            getFile(file.getName());
            BufferedReader br = new BufferedReader(new FileReader(file.getName()));
            String line;
            while ((line = br.readLine()) != null) {
                i++;
            }
            return i + 1;
        }catch (FileNotFoundException | IOException e){
        }
        return 1;
    }

    @Override
    public void updateHero(Hero hero) throws FileNotFoundException, IOException {
        Integer lineToErase = hero.getId();
        String newLine = hero.getId() + " " + hero.getName() + " " + hero.getHeroClass()
                + " " + hero.getExperience() + " " + hero.getArtefact();
        fileManager.replaceLine(lineToErase, newLine);
    }
    @Override
    public boolean previousHeroExist(){
        if (file.length() != 0)
            return true;
        return false;
    }

    @Override
    public void makeEmpty() throws java.io.FileNotFoundException {
        fileManager.makeFileEmpty();
    }


}
