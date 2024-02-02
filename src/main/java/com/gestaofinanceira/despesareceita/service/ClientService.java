package com.gestaofinanceira.despesareceita.service;

import com.gestaofinanceira.despesareceita.domainGestao.Client;
import com.gestaofinanceira.despesareceita.repository.ClientRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Setter
@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    public List<Client> getAllClients(){return this.clientRepository.findAll();}

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }
}
