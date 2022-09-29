package org.yesmine.controller;

import org.yesmine.exceptions.ArtefactNotFoundException;
import org.yesmine.model.artefacts.Artefact;
import org.yesmine.model.artefacts.ArtefactEnum;
import org.yesmine.model.artefacts.ArtefactFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArtefactService {
    public Artefact createArtefact(String name) throws ArtefactNotFoundException {
        return ArtefactFactory.getArtefact(name);
    }
    public List<String> getArtefactList(){
        return Arrays.stream(ArtefactEnum.values()).map(Enum::toString).collect(Collectors.toList());
    }
}
