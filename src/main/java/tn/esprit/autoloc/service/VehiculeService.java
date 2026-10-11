package tn.esprit.autoloc.service;

import java.util.List;
import java.util.Optional;
import tn.esprit.autoloc.domain.Vehicule;

public interface VehiculeService {
    List<Vehicule> findAll();
    Optional<Vehicule> findById(Long id);
    Vehicule create(Vehicule entity);
    Vehicule update(Long id, Vehicule entity);
    void delete(Long id);
}
