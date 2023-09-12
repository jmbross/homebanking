package com.mindhub.homebanking.services;

import com.mindhub.homebanking.dto.DtoLoan;
import com.mindhub.homebanking.models.Loan;

import java.util.List;

public interface ServiceLoan {
    void save (Loan loan);
    List<DtoLoan> findAllToListLoanDTO();
    Loan findById(Long id);
}
