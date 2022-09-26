package view.console;

import controller.SwingyController;
import dao.FileDao;
import exceptions.ArtefactNotFoundException;
import exceptions.FileNotFoundException;
import exceptions.HeroClassNotFoundException;
import exceptions.VillainClassNotFoundException;
import model.artefacts.ArtefactEnum;
import model.hero.Hero;
import model.hero.HeroEnum;
import utility.FileManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Viewer {

    SwingyController swingy;
    FileDao fileDao;

    public Viewer(SwingyController swingy) throws FileNotFoundException {
        this.swingy = swingy;
        this.fileDao = new FileDao();

    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void welcome() throws IOException {
        clearScreen();
        createBanner();
        System.out.println(Colors.GREEN_BOLD + "HELLO THERE ARE YOU READY FOR SOME ENTERTAINMENT!!");
        System.out.println("ARE YOU!!");
        System.out.println("PLEASE TYPE YES OR NO TO CONTINUE");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String response;
        response = reader.readLine();
        while (!response.equalsIgnoreCase("yes") && !response.equalsIgnoreCase("no")) {
            System.out.println(Colors.RED + "PLEASE TYPE YES OR NO TO CONTINUE");
            response = reader.readLine();
            if (response.equalsIgnoreCase("no"))
                System.exit(0);
        }
        System.out.println(Colors.CYAN_BRIGHT + "HELL YEEESSS!! YOU MADE THE RIGHT CHOICE");
    }

    private void createBanner() {
        System.out.println(Colors.YELLOW_BOLD_BRIGHT + "\t\t\t" + " ______        _____ _   _  ______   __");
        System.out.println(Colors.YELLOW_BOLD_BRIGHT + "\t\t\t" + "/ ___\\ \\      / /_ _| \\ | |/ ___\\ \\ / /");
        System.out.println(Colors.YELLOW_BOLD_BRIGHT + "\t\t\t" + "\\___ \\\\ \\ /\\ / / | ||  \\| | |  _ \\ V /");
        System.out.println(Colors.YELLOW_BOLD_BRIGHT + "\t\t\t" + " ___) |\\ V  V /  | || |\\  | |_| | | | ");
        System.out.println(Colors.YELLOW_BOLD_BRIGHT + "\t\t\t" + "|____/  \\_/\\_/  |___|_| \\_|\\____| |_|  \n");

    }

    public String creatOrSelectHero() throws IOException {
        clearScreen();
        createBanner();
        System.out.println(Colors.PURPLE_UNDERLINED + "C" + Colors.PURPLE + "REATE OR " + Colors.PURPLE_UNDERLINED + "S" + Colors.PURPLE + "ELECT YOUR HERO");
        System.out.println(Colors.RED + "PLEASE ENTER C TO CREATE, S TO SELECT, Q TO QUIT");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String response;
        response = reader.readLine();
        while (!response.equalsIgnoreCase("c") &&
                !response.equalsIgnoreCase("s") && !response.equalsIgnoreCase("q")) {
            System.out.println(Colors.RED + "PLEASE ENTER C TO CREATE, S TO SELECT, Q TO QUIT");
            response = reader.readLine();
            if (response.equalsIgnoreCase("q"))
                System.exit(0);
        }
        return response;
    }

    public void createHero() throws IOException, VillainClassNotFoundException, HeroClassNotFoundException, FileNotFoundException, ArtefactNotFoundException {
        clearScreen();
        createBanner();
        Integer heroClass = getHeroClass();
        String heroName = getHeroName();
        Integer heroArtefact = getHeroArtefact();
        fileDao.getHeroInfos(heroClass, heroName, ArtefactEnum.values()[heroArtefact].toString());
        fileDao.saveHero();
        swingy.initGame(heroName, HeroEnum.values()[heroClass].toString(), ArtefactEnum.values()[heroArtefact].toString());

    }

    public void selectHero() throws FileNotFoundException, IOException, VillainClassNotFoundException, HeroClassNotFoundException, ArtefactNotFoundException {
        clearScreen();
        createBanner();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (FileManager.file.length() == 0) {
            System.out.println(Colors.RED + "THERE IS NO PREVIOUS HEROES PLEASE CREATE YOUR OWN HERO");
            System.out.println(Colors.RED + "PLEASE TYPE C TO CREATE Q TO QUIT");
            String response = reader.readLine();
            if (response.equalsIgnoreCase("Q"))
                System.exit(0);
            if (response.equalsIgnoreCase("c"))
                createHero();
            return;
        }
        List<Hero> heroes = getHeroes();
        int heroNumber;
        while (true) {
            System.out.println("PLEASE SELECT YOUR HERO");
            String response = reader.readLine();
            try {
                heroNumber = Integer.parseInt(response);
                if (heroNumber >= 0 && heroNumber < heroes.size())
                    break;
            } catch (NumberFormatException e) {
            }
        }
        swingy.initGame(heroes.get(heroNumber).getName(), heroes.get(heroNumber).getHeroClass(), heroes.get(heroNumber).getArtefact().toString());
    }

    private static List<Hero> getHeroes() throws FileNotFoundException, IOException, HeroClassNotFoundException, ArtefactNotFoundException {
        FileDao fileDao = new FileDao();
        List<Hero> heroes = fileDao.getAllHeroes();
        for (int i = 0; i < heroes.size(); i++) {
            System.out.println(i + "- " + heroes.get(i).toString());
        }
        return heroes;
    }

    private Integer getHeroClass() throws IOException {
         for (int i = 0; i < HeroEnum.values().length; i++) {
            System.out.println(Colors.YELLOW_BOLD_BRIGHT + i + "- " + HeroEnum.values()[i].toString());
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String response;
        int heroNumber;
        while (true) {
            System.out.println("PLEASE SELECT YOUR HERO CLASS");
            response = reader.readLine();
            try {
                heroNumber = Integer.parseInt(response);
                if (heroNumber >= 0 && heroNumber < HeroEnum.values().length)
                    break;
            } catch (NumberFormatException e) {
            }
        }
        return heroNumber;
    }

    private String getHeroName() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("PLEASE ENTER YOUR HERO NAME");
        String response = reader.readLine();
        while (response.length() > 10) {
            System.out.println(Colors.RED + "PLEASE ENTER A VALID HERO NAME NO MORE THAN 10 CHARACTERS");
            response = reader.readLine();
            if (response.length() <= 10)
                break;
        }
        return response;
    }

    private Integer getHeroArtefact() throws IOException {
        int artefactNumber = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("LAST BUT NOT LEAST PLEASE SELECT AN ARTEFACT");
            List<String> artefacts = swingy.getArtefactService().getArtefactList();
            for (int i = 0; i < artefacts.size(); i++)
                System.out.println(i + "- " + artefacts.get(i));
            String artefact = reader.readLine();
            try {
                artefactNumber = Integer.parseInt(artefact);
                if (artefactNumber >= 0 && artefactNumber < ArtefactEnum.values().length)
                    break;
            } catch (NumberFormatException e) {
            }
        }
        return artefactNumber;
    }
}
