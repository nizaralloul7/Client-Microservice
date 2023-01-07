package com.example.clientservice.controller;

import com.example.clientservice.dto.ClientRequest;
import com.example.clientservice.model.Client;
import com.example.clientservice.repository.ClientRepository;
import com.example.clientservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController
{
    private final ClientRepository clientRepository;
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientRepository clientRepository, ClientService clientService)
    {
        this.clientRepository = clientRepository;
        this.clientService = clientService;
    }

    @GetMapping("/{clientCin}")
    public Client getClientByCin(@PathVariable String cin)
    {
        return clientRepository.findClientByCin(cin);
    }

    @GetMapping("/allClients")
    public List<Client> getAllClients()
    {
        return clientRepository.findAll();
    }

    @PostMapping
    public void addClient(@RequestBody ClientRequest clientRequest)
    {
        clientService.addClient(clientRequest);
    }

    @GetMapping("/{clientTel}")
    public Client getClientByTel(@PathVariable String clientTel)
    {
        return clientRepository.findClientByPhoneNumber(clientTel);
    }

    @GetMapping("/benefs/{clientCin}")
    public List<Client> getClientBeneficiaires(@PathVariable String cin)
    {
        return clientService.getClientBeneficiaires(cin);
    }

    @DeleteMapping("/delete/{cin}")
    public void deleteClientByCin(@PathVariable String cin)
    {
        clientService.deleteClient(cin);
    }

}