package com.mindhub.homebanking.repositories;

import java.util.List;

import com.mindhub.homebanking.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    //List<Person> findByLastName(String lastName);
}