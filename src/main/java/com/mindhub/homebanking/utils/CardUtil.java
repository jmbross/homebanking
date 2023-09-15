package com.mindhub.homebanking.utils;

import com.mindhub.homebanking.models.Card;
import com.mindhub.homebanking.models.CardColor;
import com.mindhub.homebanking.models.CardType;

import java.util.Random;
import java.util.Set;

public final class CardUtil {

    public static boolean existTypeCards(Set<Card> cards, CardColor cardColor, CardType cardType){

        for (Card card:cards
        ) {
            if(cardType.equals(card.getType()) && cardColor.equals(card.getColor())){
                return true;
            }
        }

        return false ;
    }

    public static int randomNumber(int numberDigits){
        return new Random().nextInt(numberDigits);
    }




}
