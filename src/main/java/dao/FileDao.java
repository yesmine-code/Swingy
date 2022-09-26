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
import java.util.List;

import static utility.FileManager.file;
import static utility.FileManager.getFile;

public class FileDao implements HeroDao{

    FileManager fileManager;
    ArtefactFactory artefactFactory;
    HeroFactory heroFactory;
    Integer heroNumber;
    String heroName;
    String artefact;

    public FileDao() throws FileNotFoundException {
        this.fileManager = getFile("PreviousHeroes");
        this.heroFactory = new HeroFactory();
        this.artefactFactory = new ArtefactFactory();
    }

    public void getHeroInfos(Integer heroNumber, String heroName, String artefact){
        this.heroNumber = heroNumber;
        this.heroName = heroName;
        this.artefact = artefact;
    }


    @Override
    public  void saveHero() throws FileNotFoundException {
        FileManager.writeIntoFile(heroName + " " + HeroEnum.values()[heroNumber].toString() + " " + HeroEnum.values()[heroNumber].getAttack()
                + " " + HeroEnum.values()[heroNumber].getDefence() + " " + HeroEnum.values()[heroNumber].getHitPoints() + " " + artefact);

    }

    @Override
    public List<Hero> getAllHeroes() throws FileNotFoundException, IOException, HeroClassNotFoundException, ArtefactNotFoundException {
            getFile(file.getName());
            BufferedReader br = new BufferedReader(new FileReader(file.getName()));
            String line;
            List<Hero> heroes = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String str[] = line.split(" ");
                heroes.add(heroFactory.createHero(str[0], str[1], ArtefactFactory.getArtefact(str[str.length - 1])));
            }
        return heroes;
    }

    private  String parseHeroNameOrClass(File file, int heroNum, String heroNameOrClass) throws IOException, FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(file.getName()));
        String line;
        Integer lineNum = 0;
        int pos = 0;
        while (lineNum <= heroNum) {
            System.out.println(lineNum + " " + heroNum);
            line = br.readLine();
            if (lineNum == heroNum){
                String str[] = line.split(" ");
                while(pos < str.length){
                    if (str[pos].equalsIgnoreCase(heroNameOrClass)) {
                        System.out.println(str[pos+ 1]);
                        return str[pos + 1];
                    }
                    pos++;
                }
            }
            lineNum++;
        }
        return null;
    }
}
