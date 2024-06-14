package org.creditcard.validation;

public class AmExValidation implements ValidationStrategy{
    @Override
    public boolean isValid(String cardNumber) {
        return (cardNumber.startsWith("34")
                || cardNumber.startsWith("37"))
                && cardNumber.length() == 15
                && cardNumber.matches("\\d+");
    }

    @Override
    public String type(String card) {
        return "American Express";
    }


}
