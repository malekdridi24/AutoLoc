package tn.esprit.autoloc.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.EmployeRepository;
import tn.esprit.autoloc.service.EmployeService;

@Service
@Transactional
public class EmployeServiceImpl implements EmployeService {
    private final EmployeRepository repository;

    public EmployeServiceImpl(EmployeRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employe> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Employe> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Employe create(Employe entity) {
        return repository.save(entity);
    }

    @Override
    public Employe update(Long id, Employe entity) {
        if (!repository.existsById(id)) {
            throw new java.util.NoSuchElementException("Employe introuvable avec id : " + id);
        }
        entity.setIdEmploye(id);
        return repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new java.util.NoSuchElementException("Employe introuvable avec id : " + id);
        }
        repository.deleteById(id);
    }
}
