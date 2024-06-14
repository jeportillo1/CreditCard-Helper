package org.creditcard.cardfactory;

import org.creditcard.validation.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardFactoryProviderTest {

    @Test
    void getCreditCardTypeVisa() {

        String cardNumber = "4123456789123";
        assertEquals("Visa",new VisaValidation().type(cardNumber));

    }

    @Test
    void getCreditCardTypeMaster() {

        String cardNumber = "5567894523129089";
        assertEquals("Mastercard",new MasterValidation().type(cardNumber));
    }

    @Test
    void getCreditCardTypeDiscover() {

        String cardNumber = "6011111100007756";
        assertEquals("Discover",new DiscoverValidation().type(cardNumber));
    }

    @Test
    void getCreditCardTypeAm() {

        String cardNumber = "347856341908126";
        assertEquals("American Express",new AmExValidation().type(cardNumber));
    }

    @Test
    void getCreditCardTypeRand() {
        String cardNumber = "";
        assertEquals("Invalid: empty/null card number", new RandomValidation().type(cardNumber));
    }
}