package org.yesmine.model.artefacts;

import lombok.Getter;

@Getter
public enum ArtefactEnum {
    GUNWEAPON("gunWeapon", 1200),
    KNIFEWEAPON("knifeWeapon", 1000),
    FIREWEAPON("fireWeapon", 900),
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

}
