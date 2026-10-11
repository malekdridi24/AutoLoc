package tn.esprit.autoloc.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.repository.ContratRepository;
import tn.esprit.autoloc.service.ContratService;

@Service
@Transactional
public class ContratServiceImpl implements ContratService {
    private final ContratRepository repository;

    public ContratServiceImpl(ContratRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contrat> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Contrat> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Contrat create(Contrat entity) {
        return repository.save(entity);
    }

    @Override
    public Contrat update(Long id, Contrat entity) {
        if (!repository.existsById(id)) {
            throw new java.util.NoSuchElementException("Contrat introuvable avec id : " + id);
        }
        entity.setIdContrat(id);
        return repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new java.util.NoSuchElementException("Contrat introuvable avec id : " + id);
        }
        repository.deleteById(id);
    }
}
