package com.mindhub.homebanking.dto;

import com.mindhub.homebanking.models.Card;
import com.mindhub.homebanking.models.CardColor;
import com.mindhub.homebanking.models.CardType;

import java.time.LocalDate;

public class DtoCard {
    private Long id;
    private String cardholder;
    private CardColor color;
    private CardType type;
    private String number;
    private int cvv;
    private LocalDate fromDate;
    private LocalDate thruDate;

    public DtoCard(){

    }

    public DtoCard(Card card) {
        this.id = card.getId();
        this.cardholder = card.getCardholder();
        this.color = card.getColor();
        this.type = card.getType();
        this.number = card.getNumber();
        this.cvv = card.getCvv();
        this.fromDate = card.getFromDate();
        this.thruDate = card.getThruDate();
    }

    public Long getId() {
        return id;
    }
    public String getCardholder() {
        return cardholder;
    }
    public CardColor getColor() {
        return color;
    }
    public CardType getType() {
        return type;
    }
    public String getNumber() {
        return number;
    }
    public int getCvv() {
        return cvv;
    }
    public LocalDate getFromDate() {
        return fromDate;
    }
    public LocalDate getThruDate() {
        return thruDate;
    }
}
