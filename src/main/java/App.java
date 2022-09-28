import controller.SwingyController;
import exceptions.ArtefactNotFoundException;
import exceptions.FileNotFoundException;
import exceptions.HeroClassNotFoundException;
import exceptions.VillainClassNotFoundException;
import model.artefacts.Artefact;
import model.artefacts.ArtefactEnum;
import model.artefacts.Helm;
import view.console.Viewer;

import java.io.IOException;

public class App {
    public static void main(String args[]) throws IOException, VillainClassNotFoundException, HeroClassNotFoundException, FileNotFoundException, ArtefactNotFoundException {
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
            if (swing.reachBorder()) {
                Artefact gun = new Helm("gunWeapon", 500);
                swing.getHero().setExperience(2500);
                swing.getHero().setArtefact(gun);
                swing.updateHero(swing.getHero());
                view.winingPrint();
            }
        }
    }
}
