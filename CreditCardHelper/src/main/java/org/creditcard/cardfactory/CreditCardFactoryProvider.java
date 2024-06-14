package org.creditcard.cardfactory;

import org.creditcard.validation.*;

public class CreditCardFactoryProvider {
    public static CreditCardFactory getCreditCardFactory(String cardNumber) {
        if (new VisaValidation().isValid(cardNumber)) {
            return new VisaCCFactory();
        } else if (new MasterValidation().isValid(cardNumber)) {
            return new MasterCCFactory();
        } else if (new AmExValidation().isValid(cardNumber)) {
            return new AmExCCFactory();
        } else if (new DiscoverValidation().isValid(cardNumber)) {
            return new DiscoverCCFactory();
        } else {
            return new RandomCardFactory();
        }
    }

    public static String getCreditCardType(String cardNumber){
        if (new VisaValidation().isValid(cardNumber)) {
            return new VisaValidation().type(cardNumber);
        } else if (new MasterValidation().isValid(cardNumber)) {
            return new MasterValidation().type(cardNumber);
        } else if (new AmExValidation().isValid(cardNumber)) {
            return new AmExValidation().type(cardNumber);
        } else if (new DiscoverValidation().isValid(cardNumber)) {
            return new DiscoverValidation().type(cardNumber);
        } else {
            return new RandomValidation().type(cardNumber);
        }
    }
}
