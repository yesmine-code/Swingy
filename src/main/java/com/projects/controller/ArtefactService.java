package com.projects.controller;

import com.projects.exceptions.ArtefactNotFoundException;
import com.projects.model.artefacts.Artefact;
import com.projects.model.artefacts.ArtefactEnum;
import com.projects.model.artefacts.ArtefactFactory;

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
