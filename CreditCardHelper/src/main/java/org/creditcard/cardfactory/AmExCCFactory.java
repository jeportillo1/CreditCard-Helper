package org.creditcard.cardfactory;

import org.creditcard.models.AmExCC;
import org.creditcard.models.CreditCard;
import org.creditcard.validation.AmExValidation;
import org.creditcard.validation.ValidationStrategy;

public class AmExCCFactory implements CreditCardFactory{
    private ValidationStrategy validator = new AmExValidation();
    @Override
    public CreditCard createCreditCard(String cardNumber, String expiryDate, String cardHolderName,String cardType) {
        return new AmExCC(cardNumber, expiryDate, cardHolderName,cardType);
    }

    @Override
    public boolean isValid(String cardNumber) {
        return validator.isValid(cardNumber);
    }
}
