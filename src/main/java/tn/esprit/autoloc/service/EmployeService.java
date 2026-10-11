package tn.esprit.autoloc.service;

import java.util.List;
import java.util.Optional;
import tn.esprit.autoloc.domain.Employe;

public interface EmployeService {
    List<Employe> findAll();
    Optional<Employe> findById(Long id);
    Employe create(Employe entity);
    Employe update(Long id, Employe entity);
    void delete(Long id);
}
