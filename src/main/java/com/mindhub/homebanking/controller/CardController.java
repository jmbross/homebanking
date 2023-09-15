package com.mindhub.homebanking.controller;

import com.mindhub.homebanking.dto.DtoCard;
import com.mindhub.homebanking.models.Card;
import com.mindhub.homebanking.models.CardColor;
import com.mindhub.homebanking.models.CardType;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.services.ServiceCard;
import com.mindhub.homebanking.services.ServiceClient;
import com.mindhub.homebanking.utils.CardUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping(value = "/clients/current/cards")
    public ResponseEntity<Object> createCard(@RequestParam CardType cardType, @RequestParam CardColor cardColor, Authentication authentication){
        Client client = serviceClient.findByEmail(authentication.getName());
        if (cardType == null || cardColor == null){
            return new ResponseEntity<>("Seleccione el tipo y color de su nueva tarjeta", HttpStatus.FORBIDDEN);
        }

        /*if (( client.getCards()
                .stream().filter(card -> card.getType().equals(cardType))
                .collect(Collectors.toList()).size() < 3 ))*/


        if (!CardUtil.existTypeCards(client.getCards(), cardColor, cardType)){
            Card card = new Card(
                    (client.getFirstName() + " " + client.getLastName()), cardType, cardColor,
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
            return new ResponseEntity<>("Ya tenes una tarjeta de " + cardType + " de color " + cardColor, HttpStatus.FORBIDDEN);
        }
    }
    @GetMapping(value = "client/current/cards")
    public List<DtoCard> readCards (Authentication authentication){
        Client client= serviceClient.findByEmail(authentication.getName());
        return serviceCard.findByClientToCardDTO(client);
    }
}