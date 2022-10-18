package org.yesmine;

import org.yesmine.controller.SwingyController;
import org.yesmine.exceptions.ArtefactNotFoundException;
import org.yesmine.exceptions.HeroClassNotFoundException;
import org.yesmine.exceptions.VillainClassNotFoundException;
import org.yesmine.view.console.Viewer;
import org.yesmine.view.swing.Swing;
import java.io.IOException;
import java.util.logging.Level;

public class App {
    public static void main(String args[]) throws IOException, VillainClassNotFoundException, HeroClassNotFoundException, ArtefactNotFoundException, InterruptedException {
        if (args.length < 1 || args.length > 2)
            exit("WRONG NUMBER OF ARGUMENTS");
        boolean db = false;
        if (args.length == 2 ) {
            if ("db".equalsIgnoreCase(args[1])) {
                java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF); //disable hibernate logs
                db = true;
            }
            else
                exit("WRONG ARGUMENTS");
        }
        SwingyController swingy = new SwingyController(db);
        if ("console".equalsIgnoreCase(args[0])){
            Viewer view = new Viewer(swingy);
            while (true)
                view.welcome();
        }
       else if ("gui".equalsIgnoreCase(args[0])){
            Swing swing = new Swing(swingy);
            swing.welcome();
        }
       else
            exit("WRONG ARGUMENTS");

    }

    private static void exit(String notif){
        System.out.println(notif);
        System.exit(0);
    }
}
