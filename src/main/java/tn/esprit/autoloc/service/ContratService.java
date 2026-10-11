package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.repository.ContratRepository;

import java.util.List;
import java.util.Optional;

public class ContratService implements IContratService {

    ContratRepository contratRepository;

    @Override
    public List<Contrat> findAll() {
        return contratRepository.findAll();
    }

    @Override
    public Optional<Contrat> findById(Long id) {
        return contratRepository.findById(id);
    }

    @Override
    public Contrat create(Contrat entity) {
        return contratRepository.save(entity);
    }

    @Override
    public Contrat update(Long id, Contrat entity) {
        return contratRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        contratRepository.deleteById(id);
    }
}
