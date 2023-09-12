package com.mindhub.homebanking.controller;

import com.mindhub.homebanking.dto.DtoCard;
import com.mindhub.homebanking.models.Card;
import com.mindhub.homebanking.models.CardColors;
import com.mindhub.homebanking.models.CardTypes;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.services.ServiceCard;
import com.mindhub.homebanking.services.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CardController {
    @Autowired
    ServiceClient serviceClient;
    @Autowired
    ServiceCard serviceCard;
    @RequestMapping(value = "/clients/current/cards", method = RequestMethod.POST)
    public ResponseEntity<Object> createCard(@RequestParam CardTypes cardTypes, @RequestParam CardColors cardColors, Authentication authentication){
        Client client = serviceClient.findByEmail(authentication.getName());
        if (cardTypes == null || cardColors == null){
            return new ResponseEntity<>("Seleccione el tipo y color de su nueva tarjeta", HttpStatus.FORBIDDEN);
        }
        if ( client.getCards()
                .stream().filter(card -> card.getType().equals(cardTypes))
                .collect(Collectors.toList()).size() < 3 ){

            Card card = new Card(
                    (client.getFirstName() + " " + client.getLastName()), cardTypes, cardColors,
                    ((int)(Math.random() * 9999 + 1)) + "-" + ((int)(Math.random() * 9999 + 1)) + "-" +
                            ((int)(Math.random() * 9999 + 1)) + "-" + ((int)(Math.random() * 9999 + 1)),
                    (int)(Math.random() * 999 + 1), LocalDate.now(), LocalDate.now().plusYears(5));
            while (serviceCard.findByNumber(card.getNumber()) != null){
                card.setNumber(
                        ((int)(Math.random() * 9999 + 1)) + "-" + ((int)(Math.random() * 9999 + 1)) + "-" +
                                ((int)(Math.random() * 9999 + 1)) + "-" + ((int)(Math.random() * 9999 + 1))
                );
            }
            client.addCards(card);
            serviceCard.save(card);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Solamente se pueden generar 3 tarjetas de cada tipo", HttpStatus.FORBIDDEN);
        }
    }
    @RequestMapping(value = "client/current/cards")
    public List<DtoCard> readCards (Authentication authentication){
        Client client= serviceClient.findByEmail(authentication.getName());
        return serviceCard.findByClientToCardDTO(client);
    }
}