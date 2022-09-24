package view.console;

import controller.SwingyController;
import exceptions.HeroClassNotFoundException;
import exceptions.VillainClassNotFoundException;
import model.hero.HeroEnum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Viewer {

    SwingyController swingy;

    public Viewer(SwingyController swingy) {
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
        while (!response.equalsIgnoreCase("yes") && !response.equalsIgnoreCase("yes")) {
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

    public void createHero() throws IOException, VillainClassNotFoundException, HeroClassNotFoundException {
        clearScreen();
        createBanner();
        for (int i = 0; i < HeroEnum.values().length; i++) {
            System.out.println(Colors.YELLOW_BOLD_BRIGHT + i + "- " + HeroEnum.values()[i].toString());
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int heroNumber;
        while (true) {
            System.out.println("PLEASE SELECT YOUR HERO CLASS");
            String response = reader.readLine();
            try {
                heroNumber = Integer.parseInt(response);
                if (heroNumber >= 0 && heroNumber < HeroEnum.values().length)
                    break;
            } catch (NumberFormatException e) {

            }
        }
        System.out.println("PLEASE ENTER YOUR HERO NAME");
        String response = reader.readLine();
        while (response.length() > 10) {
            System.out.println(Colors.RED + "PLEASE ENTER A VALID HERO NAME NO MORE THAN 10 CHARACTERS");
            response = reader.readLine();
            if (response.length() <= 10)
                break;
        }
        swingy.initGame(response, HeroEnum.values()[heroNumber].toString());
    }

    public void selectHero() {

    }
}

