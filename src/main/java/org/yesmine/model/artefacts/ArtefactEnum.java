package org.yesmine.model.artefacts;

import lombok.Getter;

@Getter
public enum ArtefactEnum {
    GUNWEAPON("gunWeapon", 1200, "images/gunweapon.png"),
    KNIFEWEAPON("knifeWeapon", 1000, "images/knifeweapon.png"),
    FIREWEAPON("fireWeapon", 900, "images/fireweapon.png"),
    BREASTARMOR("breastArmor", 500, "images/breastarmor.png"),
    HEADARMOR("headArmor", 700, "images/headarmor.png"),
    FACEARMOR("faceArmor", 400, "images/facearmor.png"),
    HOLEFACEHELM("holeFaceHelm", 700,"images/holefacehelm.png"),
    NASALHELM("nasalHelm", 600, "images/nasalhelm.png"),
    FLATHELM("flatHelm", 500, "images/flathelm.png");
    private String name;
    private Integer power;
    private String image;

    ArtefactEnum(String name, Integer power, String image) {
        this.name = name;
        this.power = power;
        this.image = image;
    }

}
