package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.util.List;

@Service
@AllArgsConstructor

public class VehiculeService implements IVehiculeService {

     VehiculeRepository vehiculeRepository;

    public List<Vehicule> retrieveAllVehicules() { return vehiculeRepository.findAll(); }

    public Vehicule retrieveVehicule(Long idVehicule) {return vehiculeRepository.findById(idVehicule).orElse(null); }


    public Vehicule addVehicule(Vehicule v) { return vehiculeRepository.save(v); }

    public Vehicule modifyVehicule(Vehicule v) { return vehiculeRepository.save(v); }

    public void removeVehicule(Long idVehicule) { vehiculeRepository.deleteById(idVehicule); }
}
