package view.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Viewer {

    public void clearScreen(){
        //System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void welcome() throws IOException {
        clearScreen();
        createBanner();
        System.out.println(Colors.GREEN_BOLD +"HELLO THERE ARE YOU READY FOR SOME ENTERTAINMENT!!");
        System.out.println("ARE YOU!!");
        System.out.println("PLEASE TYPE YES OR NO TO CONTINUE");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String response;
        response = reader.readLine();
        while(!response.equalsIgnoreCase("yes") && !response.equalsIgnoreCase("yes")) {
            System.out.println(Colors.RED+ "PLEASE TYPE YES OR NO TO CONTINUE");
            response = reader.readLine();
            if (response.equalsIgnoreCase("no"))
                System.exit(0);
        }
        System.out.println(Colors.CYAN_BRIGHT + "HELL YEEESSS!! YOU MADE THE RIGHT CHOICE");
    }

    private static void createBanner() {
        System.out.println(Colors.YELLOW_BOLD_BRIGHT +" ______        _____ _   _  ______   __");
        System.out.println(Colors.YELLOW_BOLD_BRIGHT +"/ ___\\ \\      / /_ _| \\ | |/ ___\\ \\ / /");
        System.out.println(Colors.YELLOW_BOLD_BRIGHT +"\\___ \\\\ \\ /\\ / / | ||  \\| | |  _ \\ V /");
        System.out.println(Colors.YELLOW_BOLD_BRIGHT+" ___) |\\ V  V /  | || |\\  | |_| | | | ");
        System.out.println(Colors.YELLOW_BOLD_BRIGHT +"|____/  \\_/\\_/  |___|_| \\_|\\____| |_|  \n");

    }

}
