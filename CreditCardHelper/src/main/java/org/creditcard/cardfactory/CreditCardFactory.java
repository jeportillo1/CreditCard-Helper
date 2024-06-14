package org.creditcard.cardfactory;

import org.creditcard.models.CreditCard;

public interface CreditCardFactory {
    CreditCard createCreditCard(String cardNumber, String expiryDate, String cardHolderName,String cardType);
    boolean isValid(String cardNumber);

}
