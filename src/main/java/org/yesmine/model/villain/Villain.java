package org.yesmine.model.villain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.yesmine.model.artefacts.Artefact;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public abstract class Villain {
    @NotNull
    private String name;
    @NotNull
    private final String villainClass;
    @Min(0)
    private Integer power;
    private Artefact artefact;

    protected Villain(String name, String villainClass, Integer power, Artefact artefact) {
        this.name = name;
        this.villainClass = villainClass;
        this.power = power;
        this.artefact = artefact;
    }
}
