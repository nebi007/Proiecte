package service;

import domain.Client;
import repository.Repository;

import java.util.Collection;

public class ClientService {
    private Repository<String, Client> clientRepository;

    public ClientService(Repository<String, Client> clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Collection<Client> findAll(){return clientRepository.findAll();}
}

