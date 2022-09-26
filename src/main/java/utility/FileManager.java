package utility;

import exceptions.FileNotFoundException;

import java.io.*;

public class FileManager {
    public static File file;
    public static FileManager fileManager;

    private FileManager(){

    }
    private static void createFile(String filename) throws FileNotFoundException {
        try {
            File myObj = new File(filename);
            myObj.createNewFile();
            file = myObj;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            throw new FileNotFoundException(file.getName());
        }
    }
    public static FileManager getFile(String fileName) throws FileNotFoundException{
        if(fileManager == null){
            fileManager = new FileManager();
            createFile(fileName);
        }
        return fileManager;
    }

    public static void writeIntoFile( String str) throws FileNotFoundException {
        getFile(file.getName());
        try {
            FileWriter myWriter = new FileWriter(file.getName(), true);
            PrintWriter printWriter = new PrintWriter(myWriter);
            printWriter.println(str);
            printWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

}
