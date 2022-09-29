package org.yesmine.exceptions;

public class HeroClassNotFoundException extends Exception {
    public HeroClassNotFoundException(String heroclass) {
        super(heroclass + " this hero type doesn't exist yet :D");
    }
}
