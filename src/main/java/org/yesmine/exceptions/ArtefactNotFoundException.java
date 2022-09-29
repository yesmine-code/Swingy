package org.yesmine.exceptions;

public class ArtefactNotFoundException extends Exception {
    public ArtefactNotFoundException(String name) {
        super(name + " this artefact doesn't exist yet :D");
    }
}
