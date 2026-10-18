package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.repository.ClientRepository;

import java.util.List;
@Service
@AllArgsConstructor

public class ClientService  implements IClientService{

    ClientRepository clientrepository;

    @Override
    public List<Client> retrieveAllClients() {
        return clientrepository.findAll();
    }

    @Override
    public Client addClient(Client c) {

        return clientrepository.save(c);
    }

    @Override
    public Client updateClient(Client c) {
        return clientrepository.save(c);
    }

    @Override
    public Client retrieveClient(Long idClient) {
        return clientrepository.findById(idClient).orElse(null);
    }

    @Override
    public void removeClient(Long idClient) {
        clientrepository.deleteById(idClient);
    }

}
