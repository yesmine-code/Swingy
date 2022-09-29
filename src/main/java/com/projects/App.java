package com.projects;

import com.projects.controller.SwingyController;
import com.projects.exceptions.ArtefactNotFoundException;
import com.projects.exceptions.FileNotFoundException;
import com.projects.exceptions.HeroClassNotFoundException;
import com.projects.exceptions.VillainClassNotFoundException;
import com.projects.view.console.Viewer;

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
