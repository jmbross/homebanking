package com.mindhub.homebanking.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CardUtilTest {

    @Test
    public void cardNumberIsCreated(){
        String cardNumber = CardUtil.randomNumber(9999) + "" +
                CardUtil.randomNumber(9999) + "" +
                CardUtil.randomNumber(9999) + "" +
                CardUtil.randomNumber(9999);
        assertThat(cardNumber,is(not(emptyOrNullString())));

    }

    @Test
    public void getCVV(){
        String cvvCode = CardUtil.randomNumber(999) + "";
        assertThat(cvvCode,is(not(emptyOrNullString())));

    }

    @Test
    public void IsThreeDigitCVV(){
        String cvvCode = CardUtil.randomNumber(999)+ "" ;
        assertThat(cvvCode.length(), equalTo(3));
    }

}