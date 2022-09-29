package com.projects.exceptions;

public class VillainClassNotFoundException extends Exception {
    public VillainClassNotFoundException(String name) {
        super(name + " this villain don't exist yet :D");
    }
}
