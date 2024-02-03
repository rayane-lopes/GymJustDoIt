package com.gestaofinanceira.despesareceita.controller;
import com.gestaofinanceira.despesareceita.domainGestao.Client;
import com.gestaofinanceira.despesareceita.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
    @RequestMapping("/clients")
    public class    ClientController {
    private List<Client> clients = new ArrayList<>();
        @Autowired
        private ClientService clientService;

        @GetMapping
        public List<Client> getAllClients(){
            return clientService.findAll();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Client> getClientById(@PathVariable Long id) {
            Optional<Client> client = clientService.findById(id);
            if (client.isPresent()) {
                return new ResponseEntity<>(client.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public Client createClient(@RequestBody Client client) {
            return clientService.save(client);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client updatedClient) {
            Optional<Client> clientOptional = clientService.findById(id);
            if (clientOptional.isPresent()) {
                Client client = clientOptional.get();
                client.setName(updatedClient.getName());
                client.setEmail(updatedClient.getEmail());
                clientService.save(client);

                return ResponseEntity.ok(client);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
            @DeleteMapping("/{id}")
            public ResponseEntity<HttpStatus> deleteClient(@PathVariable Long id) {
                try {
                    clientService.deleteById(id);
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                } catch (Exception e) {
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
  }


