package com.projects.exceptions;

public class FileNotFoundException extends Exception{
    public FileNotFoundException(String fileName){
        super(fileName + "NOT FOUND");
    }

}
