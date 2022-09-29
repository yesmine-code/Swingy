package com.projects.view.console;

import com.projects.controller.SwingyController;
import com.projects.exceptions.ArtefactNotFoundException;
import com.projects.exceptions.FileNotFoundException;
import com.projects.exceptions.HeroClassNotFoundException;
import com.projects.exceptions.VillainClassNotFoundException;
import com.projects.model.artefacts.ArtefactEnum;
import com.projects.model.hero.Hero;
import com.projects.model.hero.HeroEnum;
import com.projects.model.villain.Villain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Viewer {

    static SwingyController swingy;


    public Viewer(SwingyController swingy) throws FileNotFoundException {
        this.swingy = swingy;

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
        swingy.initGame(-1, heroName, HeroEnum.values()[heroClass].toString(), ArtefactEnum.values()[heroArtefact].toString());
        swingy.saveHero(swingy.getHero());
        printMap();
    }

    public void startGame() throws IOException, InterruptedException, FileNotFoundException {
        while (!swingy.reachBorder()) {
            setMove();
            printMap();
            if (swingy.reachBorder()){
                winingPrint();
                break;
            }
            if (!fightScenario())
                break;
        }
        swingy.updateHero();
    }

    public void selectHero() throws FileNotFoundException, IOException, VillainClassNotFoundException, HeroClassNotFoundException, ArtefactNotFoundException {
        clearScreen();
        createBanner();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Hero> heroes = getHeroes();
        if (heroes.isEmpty()) {
            swingy.makeEmpty();
            createNewHero();
            return;
        }
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
        swingy.initGame(heroes.get(heroNumber).getId(), heroes.get(heroNumber).getName(), heroes.get(heroNumber).getHeroClass(), heroes.get(heroNumber).getArtefact().toString());
        printMap();
    }

    private void createNewHero() throws IOException, VillainClassNotFoundException, HeroClassNotFoundException, FileNotFoundException, ArtefactNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        if (swingy.previousHeroExist())
            System.out.println(Colors.RED + "THERE IS NO PREVIOUS HEROES PLEASE CREATE YOUR OWN HERO");
        while (true) {
            System.out.println(Colors.RED + "PLEASE TYPE C TO CREATE Q TO QUIT");
            String response = reader.readLine();
            if (response.equalsIgnoreCase("Q"))
                System.exit(0);
            if (response.equalsIgnoreCase("c")) {
                createHero();
                return;
            }
        }
    }

    private static List<Hero> getHeroes() throws FileNotFoundException, IOException, HeroClassNotFoundException, ArtefactNotFoundException {
        List<Hero> heroes = swingy.getAllHeroes();
        for (int i = 0; i < heroes.size(); i++) {
            System.out.println(i + "- " + heroes.get(i).toString());
        }
        return heroes;
    }

    private Integer getHeroClass() throws IOException {
        for (int i = 0; i < HeroEnum.values().length; i++) {
            System.out.print(Colors.YELLOW_BOLD_BRIGHT + i + "- " + HeroEnum.values()[i].toString() + "\t");
            System.out.println("Attack = " + HeroEnum.values()[i].getAttack() + " Defence = " + HeroEnum.values()[i].getDefence() + " HitPoints = "
                    + HeroEnum.values()[i].getHitPoints());
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
        while (response.length() > 10 || response.contains(" ")) {
            System.out.println(Colors.RED + "PLEASE ENTER A VALID HERO NAME NO MORE THAN 10 CHARACTERS AND NO SPACE");
            response = reader.readLine();
            if (response.length() <= 10)
                break;
        }
        return response;
    }

    private Integer getHeroArtefact() throws IOException {
        clearScreen();
        createBanner();
        int artefactNumber = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("LAST BUT NOT LEAST PLEASE SELECT AN ARTEFACT");
            for (int i = 0; i < ArtefactEnum.values().length; i++) {
                System.out.print(Colors.YELLOW_BOLD_BRIGHT + i + "- " + ArtefactEnum.values()[i].toString() + "\t");
                System.out.println("Power = " + ArtefactEnum.values()[i].getPower());
            }
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

    private void printMap() {
        clearScreen();
        createBanner();
        Integer mapSize = swingy.computeMapSize(swingy.getHero());
        int i = 0;
        int j;
        System.out.print("\t\t   ");
        for (i = 0; i < mapSize; i++)
            System.out.print(i + 1 + "  ");
        System.out.println();
        i = 0;
        while (i < mapSize) {
            j = 0;
            System.out.print("\t\t");
            System.out.print(i + 1 + "  ");
            while (j < mapSize) {
                if (i == swingy.getHero().getPosition().getY() && j == swingy.getHero().getPosition().getX()) {
                    System.out.print(Colors.RED + "*  " + Colors.YELLOW_BOLD_BRIGHT);
                } else
                    System.out.print("*  ");
                if (j == mapSize - 1) {
                    System.out.println();
                }
                j++;
            }
            i++;
        }
        System.out.println();
        printInfos(swingy.getHero());
    }

    private void printInfos(Hero hero) {
        System.out.println(Colors.RED + " *" + Colors.GREEN + " IS YOUR POSITION");
        System.out.println(Colors.RED_BOLD_BRIGHT + "YOU MUST REACH ONE OF THE BORDERS OF THE MAP");
        System.out.println(Colors.RED_BOLD_BRIGHT + "YOU CAN'T SEE THE VILLAINS BUT THEY CAN");
        System.out.println(Colors.PURPLE + "HERO INFOS :");
        System.out.println("-NAME: " + hero.getName() + " CLASS: " + hero.getHeroClass() + " LEVEL: " + hero.getLevel());
        System.out.println("-ATTACK: " + hero.getAttack() + " DEFENCE: " + hero.getDefence()
                + " HITPOINTS: " + hero.getHitPoints());
        System.out.println("-ARTEFACT: " + hero.getArtefact().getName()
                + " ATTACK: " + hero.getArtefact().getAttackAffect() + " DEFENCE: " + hero.getArtefact().getDefenceAffect()
                + " HITPOINTS: " + hero.getArtefact().getHitPointsAffect());
        System.out.println(Colors.GREEN + "R=RIGHT L=LEFT U=UP D=DOWN");
        System.out.println(Colors.GREEN + "PLEASE ENTER YOUR NEXT MOVE");
    }

    private void setMove() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String response = reader.readLine();
        while (!"R".equalsIgnoreCase(response) && !"L".equalsIgnoreCase(response) &&
                !"U".equalsIgnoreCase(response) && !"D".equalsIgnoreCase(response)) {
            System.out.println(Colors.GREEN + "R=RIGHT L=LEFT U=UP D=DOWN");
            System.out.println(Colors.GREEN + "PLEASE ENTER YOUR NEXT MOVE");
            response = reader.readLine();
        }
        swingy.setNewPosition(response);
    }

    public void winingPrint() throws IOException, FileNotFoundException {
        System.out.println(Colors.GREEN + "CONGRATULATIONS ON YOUR WELL-DESERVED SUCCESS");
        restartGame();
    }

    private void restartGame() throws IOException, FileNotFoundException {
        swingy.updateHero();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String response;
            System.out.println("PLEASE ENTER " + Colors.RED + "S " + Colors.GREEN + "TO START A NEW GAME" + Colors.RED + " Q " + Colors.GREEN + "TO QUIT");
            response = reader.readLine();
            if ("Q".equalsIgnoreCase(response))
                System.exit(0);
            if ("S".equalsIgnoreCase(response))
                break;
        }
    }


    private String villainMeeting(Villain villain) throws IOException, InterruptedException {
        clearScreen();
        createBanner();
        System.out.println(Colors.RED + "UNFORTUNATELY YOU JUST MET ONE OF THE VILLAINS");
        Thread.sleep(1000);
        System.out.println(Colors.BLUE + "OH MY GOOOOD!!, ITS ONE OF THE " + villain.getVillainClass().toUpperCase()
                + " HIS POWER= " + villain.getPower() + " HIS ARTEFACT=" + villain.getArtefact().getName().toUpperCase());
        System.out.println("DO YOU WANT TO FIGHT OR TO RUN");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String response;
        while (true) {
            System.out.println("PLEASE TYPE " + Colors.RED + "F " + Colors.BLUE + "TO FIGHT " + Colors.RED + "R " + Colors.BLUE + "TO RUN");
            response = reader.readLine();
            if ("R".equalsIgnoreCase(response) || "F".equalsIgnoreCase(response))
                break;
        }
        return response;
    }

    public boolean fightScenario() throws IOException, InterruptedException, FileNotFoundException {
        Villain villain = swingy.villainExist();
        if (villain != null) {
            String response = villainMeeting(villain);
            if ("R".equalsIgnoreCase(response)) {
                if (swingy.runnigSimulation()) {
                    swingy.returnToPreviousPosition();
                    printMap();
                    System.out.println(Colors.RED + "YOU JUST RETURNED TO PREVIOUS POSITION PLEASE SET YOUR NEXT MOVE");
                    return true;
                } else {
                    System.out.println("TOO LATE BODY LUCK ISN'T BY YOUR SIDE THIS TIME");
                    Thread.sleep(1000);
                    System.out.println("YOU MUST FIGHT");
                }
            }
            fightingPrint();
            if (swingy.heroWinsFight(villain)) {
                getVillainArtefact(villain);
                printMap();
                System.out.println("PLEASE SET YOUR NEXT MOVE");
                return true;
            }
            loosingPrint();
            return false;
        }
        return true;
    }

    public void loosingPrint() throws IOException, InterruptedException, FileNotFoundException {
        clearScreen();
        createBanner();
        System.out.println(Colors.RED_BOLD_BRIGHT + "GAME OVER");
        Thread.sleep(1000);
        System.out.println(Colors.GREEN + "GOOD LUCK FOR THE NEXT TIME");
        Thread.sleep(1000);
        restartGame();
    }

    private void getVillainArtefact(Villain villain) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String response = null;
        System.out.println("CONGRATULATIONS YOU JUST WON THIS FIGHT");
        System.out.println("YOU JUST WON " + villain.getPower() * 4 + " XP");
        swingy.setNewXp(villain);
        System.out.println(Colors.BLUE + "VILLAIN ARTEFACT IS " + villain.getArtefact().getName().toUpperCase());
        System.out.println("DO YOU WANT TO TAKE IT ? IF YOU DO YOU WILL DROP YOURS");
        System.out.println("PLEASE MAKE SURE YOU KEEP THE RIGHT ONE");
        while (!"T".equalsIgnoreCase(response) && !"L".equalsIgnoreCase(response)) {
            System.out.println(Colors.GREEN + "PLEASE PRESS " + Colors.RED + "T " + Colors.GREEN + "TO TAKE THE ARTEFACT " + Colors.RED + "L " + Colors.GREEN + "TO LEAVE IT");
            response = reader.readLine();
            if ("T".equalsIgnoreCase(response))
                swingy.changeArtefact(villain);
        }
    }

    public void fightingPrint() throws InterruptedException {
        clearScreen();
        createBanner();
        Thread.sleep(1000);
        System.out.println(Colors.RED + "-COME ON DO YOU FEAR ME !!");
        Thread.sleep(1000);
        System.out.println("-NO I AM JUST PRAYING FOR YOU I AM GOING TO KILL YOU");
        Thread.sleep(1000);
        System.out.println("-AOUUUUCH");
        Thread.sleep(1000);
        System.out.println("-OH MY GOD THAT HURTS");
        Thread.sleep(1000);
        System.out.println("-AYYYYY");
        Thread.sleep(1000);
    }


}
