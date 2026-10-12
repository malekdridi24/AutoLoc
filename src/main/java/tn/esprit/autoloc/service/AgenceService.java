package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.AgenceRepository;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor

public class AgenceService implements IAgenceService {

    AgenceRepository agenceRepository;


    @Override
    public List<Agence> findAll() {
        return agenceRepository.findAll();
    }

    @Override
    public Optional<Agence> findById(Long id) {
        return agenceRepository.findById(id);
    }

    @Override
    public Agence create(Agence entity) {
        return agenceRepository.save(entity);
    }

    @Override
    public Agence update(Long id, Agence entity) {
        return agenceRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        agenceRepository.deleteById(id);

    }
}
