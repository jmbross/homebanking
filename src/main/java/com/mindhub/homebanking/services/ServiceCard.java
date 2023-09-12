package com.mindhub.homebanking.services;

import com.mindhub.homebanking.dto.DtoCard;
import com.mindhub.homebanking.models.Card;
import com.mindhub.homebanking.models.Client;

import java.util.List;

public interface ServiceCard {
    void save(Card card);
    Card findByNumber(String number);
    List<DtoCard> findByClientToCardDTO(Client client);
}
