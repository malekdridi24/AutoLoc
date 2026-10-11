package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Employe;

import java.util.List;
import java.util.Optional;

public interface IEmployeService {
    List<Employe> findAll();
    Optional<Employe> findById(Long id);
    Employe create(Employe entity);
    Employe update(Long id, Employe entity);
    void delete(Long id);
}
