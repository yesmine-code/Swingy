package org.yesmine.model.hero;

public enum HeroEnum {
    VALKYRIE(500, 300, 500, "images/valkyrie.png"),
    SORCIER(400, 400, 400, "images/sorcier.png"),
    CHEVALIER(700, 250, 700, "images/chevalier.png"),
    PEKKA(700, 300, 600, "images/pekka.png"),
    PRINCE(600, 350, 600, "images/prince.png"),
    VOLEUSE(400, 500, 500, "images/voleuse.png"),
    DRAGON(450, 300, 550, "images/dragon.png");

    private Integer attack;
    private Integer defence;
    private Integer hitPoints;
    private String image;


    HeroEnum(Integer attack, Integer defence, Integer hitPoints, String image) {
        this.attack = attack;
        this.defence = defence;
        this.hitPoints = hitPoints;
        this.image = image;
    }

    public Integer getAttack() {
        return attack;
    }

    public Integer getDefence() {
        return defence;
    }

    public Integer getHitPoints() {
        return hitPoints;
    }

    public String getImage() { return image; }
}
