package com.mindhub.homebanking.services.implement;

import com.mindhub.homebanking.models.ClientLoan;
import com.mindhub.homebanking.repository.ClientLoanRepository;
import com.mindhub.homebanking.services.ServiceClientLoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceClientLoanImplement implements ServiceClientLoan {
    @Autowired
    private ClientLoanRepository clientLoanRepository;
    @Override
    public void save(ClientLoan clientLoan) {
        clientLoanRepository.save(clientLoan);
    }
}
