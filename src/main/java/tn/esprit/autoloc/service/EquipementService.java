package tn.esprit.autoloc.service;

import java.util.List;
import java.util.Optional;
import tn.esprit.autoloc.domain.Equipement;

public interface EquipementService {
    List<Equipement> findAll();
    Optional<Equipement> findById(Long id);
    Equipement create(Equipement entity);
    Equipement update(Long id, Equipement entity);
    void delete(Long id);
}
