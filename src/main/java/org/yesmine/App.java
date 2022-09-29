package org.yesmine;

import org.yesmine.controller.SwingyController;
import org.yesmine.exceptions.ArtefactNotFoundException;
import org.yesmine.exceptions.FileNotFoundException;
import org.yesmine.exceptions.HeroClassNotFoundException;
import org.yesmine.exceptions.VillainClassNotFoundException;
import org.yesmine.view.console.Viewer;

import java.io.IOException;

public class App {
    public static void main(String args[]) throws IOException, VillainClassNotFoundException, HeroClassNotFoundException, FileNotFoundException, ArtefactNotFoundException, InterruptedException {
        SwingyController swing = new SwingyController();
        Viewer view = new Viewer(swing);
        while (true) {
            view.welcome();
            String response = view.creatOrSelectHero();
            if ("c".equalsIgnoreCase(response))
                view.createHero();
            else if ("s".equalsIgnoreCase(response))
                view.selectHero();
            view.startGame();
        }
    }
}
