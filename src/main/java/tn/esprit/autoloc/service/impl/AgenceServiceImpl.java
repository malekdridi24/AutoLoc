package tn.esprit.autoloc.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.service.AgenceService;

@Service
@Transactional
public class AgenceServiceImpl implements AgenceService {
    private final AgenceRepository repository;

    public AgenceServiceImpl(AgenceRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Agence> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Agence> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Agence create(Agence entity) {
        return repository.save(entity);
    }

    @Override
    public Agence update(Long id, Agence entity) {
        if (!repository.existsById(id)) {
            throw new java.util.NoSuchElementException("Agence introuvable avec id : " + id);
        }
        entity.setIdAgence(id);
        return repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new java.util.NoSuchElementException("Agence introuvable avec id : " + id);
        }
        repository.deleteById(id);
    }
}
