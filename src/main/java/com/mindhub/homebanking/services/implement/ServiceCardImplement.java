package com.mindhub.homebanking.services.implement;

import com.mindhub.homebanking.dto.DtoCard;
import com.mindhub.homebanking.models.Card;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.repository.CardRepository;
import com.mindhub.homebanking.services.ServiceCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceCardImplement implements ServiceCard {
    @Autowired
    private CardRepository cardRepository;
    @Override
    public void save(Card card) {
        cardRepository.save(card);
    }
    @Override
    public Card findByNumber(String number) {
        return cardRepository.findByNumber(number);
    }
    @Override
    public List<DtoCard> findByClientToCardDTO(Client client) {
        return cardRepository.findByClient(client)
                .stream().map(card -> new DtoCard(card))
                .collect(Collectors.toList());
    }
}
