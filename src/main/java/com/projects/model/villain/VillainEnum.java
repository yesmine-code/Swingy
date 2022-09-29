package com.projects.model.villain;

public enum VillainEnum {
    SQUELETTES("Squelettes", 400),
    COCHONS("cochons", 500),
    BARBARES("Barbares", 550);

    private String name;
    private Integer power;

    VillainEnum(String name, Integer power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public Integer getPower() {
        return power;
    }
}
