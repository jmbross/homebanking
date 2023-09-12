package com.mindhub.homebanking.services.implement;

import com.mindhub.homebanking.dto.DtoClient;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.repository.ClientRepository;
import com.mindhub.homebanking.services.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceClientImplement implements ServiceClient {
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public void save(Client client) {
        clientRepository.save(client);
    }
    @Override
    public List<DtoClient> findAllToListClientDTO() {
        return clientRepository.findAll().stream()
                .map(client -> new DtoClient(client))
                .collect(Collectors.toList());
    }
    @Override
    public Client findByEmail(String email) {
        return clientRepository.findByEmail(email);
    }
    @Override
    public DtoClient findByEmailToClientDTO(String email) {
        return new DtoClient(clientRepository.findByEmail(email));
    }
}
