package org.creditcard.cardfactory;

import org.creditcard.models.CreditCard;
import org.creditcard.models.MasterCC;
import org.creditcard.validation.MasterValidation;
import org.creditcard.validation.ValidationStrategy;

public class MasterCCFactory implements CreditCardFactory{
    private ValidationStrategy validator = new MasterValidation();
    @Override
    public CreditCard createCreditCard(String cardNumber, String expiryDate, String cardHolderName,String cardType) {
        return new MasterCC(cardNumber, expiryDate, cardHolderName,cardType);
    }

    @Override
    public boolean isValid(String cardNumber) {
        return validator.isValid(cardNumber);
    }

}
