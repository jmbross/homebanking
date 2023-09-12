package com.mindhub.homebanking.services;

import com.mindhub.homebanking.dto.DtoClient;
import com.mindhub.homebanking.models.Client;

import java.util.List;

public interface ServiceClient {
    void save(Client client);
    List<DtoClient> findAllToListClientDTO();
    Client findByEmail(String email);
    DtoClient findByEmailToClientDTO(String email);
}
