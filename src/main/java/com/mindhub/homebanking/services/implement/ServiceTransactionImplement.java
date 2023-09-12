package com.mindhub.homebanking.services.implement;

import com.mindhub.homebanking.models.Transaction;
import com.mindhub.homebanking.repository.TransactionRepository;
import com.mindhub.homebanking.services.ServiceTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTransactionImplement implements ServiceTransaction {
    @Autowired
    private TransactionRepository transactionRepository;
    @Override
    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }
}
