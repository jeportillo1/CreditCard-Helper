package org.creditcard.cardfactory;

import org.creditcard.models.CreditCard;
import org.creditcard.models.VisaCC;
import org.creditcard.validation.ValidationStrategy;
import org.creditcard.validation.VisaValidation;

public class VisaCCFactory implements CreditCardFactory{
    private ValidationStrategy validator = new VisaValidation();
    @Override
    public CreditCard createCreditCard(String cardNumber, String expiryDate, String cardHolderName, String cardType) {
        return new VisaCC(cardNumber, expiryDate, cardHolderName,cardType);
    }

    @Override
    public boolean isValid(String cardNumber) {
        return validator.isValid(cardNumber);
    }
}
