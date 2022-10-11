package org.yesmine;

import org.yesmine.controller.SwingyController;
import org.yesmine.exceptions.ArtefactNotFoundException;
import org.yesmine.exceptions.HeroClassNotFoundException;
import org.yesmine.exceptions.VillainClassNotFoundException;
import org.yesmine.view.console.Viewer;
import org.yesmine.view.swing.Swing;

import javax.swing.*;
import java.io.IOException;
import java.util.logging.Level;

public class App {
    public static void main(String args[]) throws IOException, VillainClassNotFoundException, HeroClassNotFoundException, ArtefactNotFoundException, InterruptedException {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF); //disable hibernate logs
        SwingyController swing = new SwingyController();
        Viewer view = new Viewer(swing);;
        Swing swing1 = new Swing(swing);
        swing1.welcome();
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
