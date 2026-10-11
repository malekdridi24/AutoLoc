package tn.esprit.autoloc.service;

import java.util.List;
import java.util.Optional;
import tn.esprit.autoloc.domain.Contrat;

public interface ContratService {
    List<Contrat> findAll();
    Optional<Contrat> findById(Long id);
    Contrat create(Contrat entity);
    Contrat update(Long id, Contrat entity);
    void delete(Long id);
}
