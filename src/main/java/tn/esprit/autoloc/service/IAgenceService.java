package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Agence;

import java.util.List;
import java.util.Optional;

public interface IAgenceService {
    List<Agence> findAll();
    Agence retrieveAgence(Long id);
    Agence create(Agence a);
    Agence update(Agence a);
    void delete(Long id);
}

