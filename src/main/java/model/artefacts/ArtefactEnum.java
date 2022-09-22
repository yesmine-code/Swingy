package model.artefacts;

public enum ArtefactEnum {
    GUNWEAPON("gun", 1200),
    KNIFEWEAPON("knife", 1000),
    FIREWEAPON("fire", 900),
    BREASTARMOR("breastArmor", 500),
    HEADARMOR("headArmor", 700),
    FACEARMOR("faceArmor", 400),
    HOLEFACEHELM("holeFaceHelm", 700),
    NASALHELM("nasalHelm", 600),
    FLATHELM("flatHelm", 500);
    private String name;
    private Integer power;

    ArtefactEnum(String name, Integer power) {
        this.name = name;
        this.power = power;
    }

    public Integer getPower() {
        return power;
    }

    public String getName() {
        return name;
    }
}
