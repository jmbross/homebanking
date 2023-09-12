package com.mindhub.homebanking.services;

import com.mindhub.homebanking.dto.DtoAccount;
import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Client;

import java.util.List;

public interface ServiceAccount {
     void save(Account account);
     Account findByNumber(String number);
     DtoAccount findByIdToAccountDTO(Long id);
     List<DtoAccount> findByClientToListAccountDTO(Client client);
}
