package org.yesmine.model.villain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VillainEnum {
    SQUELETTES("Squelettes", 400),
    COCHONS("cochons", 500),
    BARBARES("Barbares", 550);

    private String name;
    private Integer power;
}
