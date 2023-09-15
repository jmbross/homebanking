package com.mindhub.homebanking.repository;

import com.mindhub.homebanking.models.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class AccountRepositoryTest {


    @Autowired
    AccountRepository accountRepository;

    @Test
    public void existAccount(){
        List<Account> accounts = accountRepository.findAll();
        assertThat(accounts,is(not(empty())));
    }

    @Test
    public void AccountBalancePositivo() {
        List<Account> accounts = accountRepository.findAll();
        for (Account account : accounts) {
            assertThat(account.getBalance(), greaterThan(-1d));
        }
    }
}