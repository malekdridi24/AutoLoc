package tn.esprit.autoloc.service;

import java.util.List;
import java.util.Optional;
import tn.esprit.autoloc.domain.Agence;

public interface AgenceService {
    List<Agence> findAll();
    Optional<Agence> findById(Long id);
    Agence create(Agence entity);
    Agence update(Long id, Agence entity);
    void delete(Long id);
}
