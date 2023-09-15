package com.mindhub.homebanking.repository;

import com.mindhub.homebanking.models.Client;
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
class ClientRepositoryTest {

    @Autowired
    ClientRepository clientRepository;

    @Test
    public void existClient(){
        List<Client> clients = clientRepository.findAll();
        assertThat(clients,is(not(empty())));
    }

    @Test
    public void existPersonalAccount() {
        List<Client> clients = clientRepository.findAll();
        for (Client client :clients) {
            assertThat(client.getAccounts().size(), greaterThan(0));
        }
    }

}