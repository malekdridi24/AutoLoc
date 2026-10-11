package tn.esprit.autoloc.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.repository.EquipementRepository;
import tn.esprit.autoloc.service.EquipementService;

@Service
@Transactional
public class EquipementServiceImpl implements EquipementService {
    private final EquipementRepository repository;

    public EquipementServiceImpl(EquipementRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Equipement> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Equipement> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Equipement create(Equipement entity) {
        return repository.save(entity);
    }

    @Override
    public Equipement update(Long id, Equipement entity) {
        if (!repository.existsById(id)) {
            throw new java.util.NoSuchElementException("Equipement introuvable avec id : " + id);
        }
        entity.setIdEquipement(id);
        return repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new java.util.NoSuchElementException("Equipement introuvable avec id : " + id);
        }
        repository.deleteById(id);
    }
}
