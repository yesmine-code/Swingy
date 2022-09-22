package model.villain;

public enum VillainEnum {
    SQUELETTES("Squelettes", 800),
    COCHONS("cochons", 900),
    BARBARES("Barbares", 1000);

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
