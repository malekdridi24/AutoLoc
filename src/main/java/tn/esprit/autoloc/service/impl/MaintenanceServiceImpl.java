package tn.esprit.autoloc.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.repository.MaintenanceRepository;
import tn.esprit.autoloc.service.MaintenanceService;

@Service
@Transactional
public class MaintenanceServiceImpl implements MaintenanceService {
    private final MaintenanceRepository repository;

    public MaintenanceServiceImpl(MaintenanceRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Maintenance> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Maintenance> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Maintenance create(Maintenance entity) {
        return repository.save(entity);
    }

    @Override
    public Maintenance update(Long id, Maintenance entity) {
        if (!repository.existsById(id)) {
            throw new java.util.NoSuchElementException("Maintenance introuvable avec id : " + id);
        }
        entity.setIdMaintenance(id);
        return repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new java.util.NoSuchElementException("Maintenance introuvable avec id : " + id);
        }
        repository.deleteById(id);
    }
}
