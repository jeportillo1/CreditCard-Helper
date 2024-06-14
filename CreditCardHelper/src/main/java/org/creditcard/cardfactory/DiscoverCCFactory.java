package org.creditcard.cardfactory;

import org.creditcard.models.CreditCard;
import org.creditcard.models.DiscoverCC;
import org.creditcard.validation.DiscoverValidation;
import org.creditcard.validation.ValidationStrategy;

public class DiscoverCCFactory implements CreditCardFactory{
    private ValidationStrategy validator = new DiscoverValidation();
    @Override
    public CreditCard createCreditCard(String cardNumber, String expiryDate, String cardHolderName,String cardType) {
        return new DiscoverCC(cardNumber, expiryDate, cardHolderName,cardType);
    }

    @Override
    public boolean isValid(String cardNumber) {
        return validator.isValid(cardNumber);
    }

}
