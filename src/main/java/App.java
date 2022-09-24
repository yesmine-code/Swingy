import controller.SwingyController;
import exceptions.HeroClassNotFoundException;
import exceptions.VillainClassNotFoundException;
import view.console.Viewer;

import java.io.IOException;

public class App {
    public static void main(String args[]) throws IOException, VillainClassNotFoundException, HeroClassNotFoundException {
        SwingyController swing = new SwingyController();
        Viewer view = new Viewer(swing);
        view.welcome();
        String response = view.creatOrSelectHero();
        if ("c".equalsIgnoreCase(response))
            view.createHero();
        else if ("s".equalsIgnoreCase(response))
            view.selectHero();
    }
}
