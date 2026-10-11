package tn.esprit.autoloc.service;

import java.util.List;
import java.util.Optional;
import tn.esprit.autoloc.domain.Paiement;

public interface PaiementService {
    List<Paiement> findAll();
    Optional<Paiement> findById(Long id);
    Paiement create(Paiement entity);
    Paiement update(Long id, Paiement entity);
    void delete(Long id);
}
