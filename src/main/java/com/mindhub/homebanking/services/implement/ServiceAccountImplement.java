package com.mindhub.homebanking.services.implement;

import com.mindhub.homebanking.dto.DtoAccount;
import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.repository.AccountRepository;
import com.mindhub.homebanking.services.ServiceAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;
@Service
public class ServiceAccountImplement implements ServiceAccount {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }
    @Override
    public Account findByNumber(String number) {
        return accountRepository.findByNumber(number);
    }
    @Override
    public DtoAccount findByIdToAccountDTO(Long id) {
        return accountRepository.findById(id)
                .map(account -> new DtoAccount(account))
                .orElse(null);
    }
    @Override
    public List<DtoAccount> findByClientToListAccountDTO(Client client) {
        return accountRepository.findByClient(client).stream()
                .map(account -> new DtoAccount(account))
                .collect(Collectors.toList());
    }
}

