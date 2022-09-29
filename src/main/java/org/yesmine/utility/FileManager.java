package org.yesmine.utility;

import org.yesmine.exceptions.FileNotFoundException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static File file;
    public static FileManager fileManager;

    private FileManager() {

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

    public static FileManager getFile(String fileName) throws FileNotFoundException {
        if (fileManager == null) {
            fileManager = new FileManager();
            createFile(fileName);
        }
        return fileManager;
    }

    public static void writeIntoFile(String str) throws FileNotFoundException {
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

    public static void makeFileEmpty() throws java.io.FileNotFoundException {
        PrintWriter writer = new PrintWriter(file.getName());
        writer.print("");
        writer.close();
    }

    public void replaceLine(Integer lineNUmber, String newline) throws FileNotFoundException, IOException {
        List<String> fileContent = new ArrayList<>(Files.readAllLines(Path.of(file.getName()), StandardCharsets.UTF_8));
        for (int i = 0; i < fileContent.size(); i++) {
            if (i == lineNUmber - 1) {
                fileContent.set(i, newline);
                break;
            }
        }
        Files.write(Path.of(file.getName()), fileContent, StandardCharsets.UTF_8);

    }
}

