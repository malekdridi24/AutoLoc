package tn.esprit.autoloc.service;

import java.util.List;
import java.util.Optional;
import tn.esprit.autoloc.domain.Maintenance;

public interface MaintenanceService {
    List<Maintenance> findAll();
    Optional<Maintenance> findById(Long id);
    Maintenance create(Maintenance entity);
    Maintenance update(Long id, Maintenance entity);
    void delete(Long id);
}
