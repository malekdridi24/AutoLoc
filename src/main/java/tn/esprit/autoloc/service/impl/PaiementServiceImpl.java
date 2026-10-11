package tn.esprit.autoloc.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.repository.PaiementRepository;
import tn.esprit.autoloc.service.PaiementService;

@Service
@Transactional
public class PaiementServiceImpl implements PaiementService {
    private final PaiementRepository repository;
    public PaiementServiceImpl(PaiementRepository repository) { this.repository = repository; }
    @Override @Transactional(readOnly = true)
    public List<Paiement> findAll() { return repository.findAll(); }
    @Override @Transactional(readOnly = true)
    public Optional<Paiement> findById(Long id) { return repository.findById(id); }
    @Override public Paiement create(Paiement entity) { return repository.save(entity); }
    @Override public Paiement update(Long id, Paiement entity) {
        if (!repository.existsById(id)) throw new NoSuchElementException("Paiement introuvable avec id : " + id);
        entity.setIdPaiement(id);
        return repository.save(entity);
    }
    @Override public void delete(Long id) {
        if (!repository.existsById(id)) throw new NoSuchElementException("Paiement introuvable avec id : " + id);
        repository.deleteById(id);
    }
}
