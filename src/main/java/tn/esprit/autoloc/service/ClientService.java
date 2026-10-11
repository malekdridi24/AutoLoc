package tn.esprit.autoloc.service;

import java.util.List;
import java.util.Optional;
import tn.esprit.autoloc.domain.Client;

public interface ClientService {
    List<Client> findAll();
    Optional<Client> findById(Long id);
    Client create(Client entity);
    Client update(Long id, Client entity);
    void delete(Long id);
}
