package tn.esprit.autoloc.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;
import tn.esprit.autoloc.service.VehiculeService;

@Service
@Transactional
public class VehiculeServiceImpl implements VehiculeService {
    private final VehiculeRepository repository;
    public VehiculeServiceImpl(VehiculeRepository repository) { this.repository = repository; }
    @Override @Transactional(readOnly = true)
    public List<Vehicule> findAll() { return repository.findAll(); }
    @Override @Transactional(readOnly = true)
    public Optional<Vehicule> findById(Long id) { return repository.findById(id); }
    @Override public Vehicule create(Vehicule entity) { return repository.save(entity); }
    @Override public Vehicule update(Long id, Vehicule entity) {
        if (!repository.existsById(id)) throw new NoSuchElementException("Vehicule introuvable avec id : " + id);
        entity.setIdVehicule(id);
        return repository.save(entity);
    }
    @Override public void delete(Long id) {
        if (!repository.existsById(id)) throw new NoSuchElementException("Vehicule introuvable avec id : " + id);
        repository.deleteById(id);
    }
}
