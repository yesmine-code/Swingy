package org.yesmine.model.villain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VillainEnum {
    SQUELETTES("Squelettes", 400, "images/squelettes.png"),
    COCHONS("cochons", 500, "images/cochons.png"),
    BARBARES("Barbares", 550, "images/barbares.png");

    private String name;
    private Integer power;
    private String image;

    public String getImage() {
        return image;
    }
}
