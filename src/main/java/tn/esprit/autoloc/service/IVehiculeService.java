package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Vehicule;

import java.util.List;

public interface IVehiculeService {
    List<Vehicule> retrieveAllVehicules();
    Vehicule retrieveVehicule(Long idVehicule);
    Vehicule addVehicule(Vehicule v);
    Vehicule modifyVehicule(Vehicule v);
    void removeVehicule(Long idVehicule);
}
