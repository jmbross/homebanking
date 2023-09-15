package com.mindhub.homebanking.repository;

import com.mindhub.homebanking.models.Card;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class CardRepositoryTest {

    @Autowired
    CardRepository cardRepository;

    @Test
    public void existCard(){
        List<Card> cards = cardRepository.findAll();
        assertThat(cards,is(not(empty())));
    }

    @Test
    public void existTypeCard() {
        List<Card> cards = cardRepository.findAll();
        for (Card card : cards) {
            assertEquals(3, (String.valueOf(card.getCvv())).length());
        }
    }

}