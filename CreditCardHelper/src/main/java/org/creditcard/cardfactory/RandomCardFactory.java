package org.creditcard.cardfactory;

import org.creditcard.models.CreditCard;
import org.creditcard.models.RandomCard;
import org.creditcard.validation.RandomValidation;
import org.creditcard.validation.ValidationStrategy;

public class RandomCardFactory implements CreditCardFactory{

    private ValidationStrategy validator = new RandomValidation();

    @Override
    public CreditCard createCreditCard(String cardNumber, String expiryDate, String cardHolderName, String cardType) {
        return new RandomCard(cardNumber, expiryDate, cardHolderName,cardType);
    }

    @Override
    public boolean isValid(String cardNumber) {
        return validator.isValid(cardNumber);
    }
}
