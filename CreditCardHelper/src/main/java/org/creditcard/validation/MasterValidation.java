package org.creditcard.validation;

public class MasterValidation implements ValidationStrategy{
    @Override
    public boolean isValid(String cardNumber) {
        return cardNumber.startsWith("5")
                && (cardNumber.charAt(1) >= '1' && cardNumber.charAt(1) <= '5')
                && cardNumber.length() == 16 && cardNumber.matches("\\d+");
    }

    @Override
    public String type(String card) {
        return "Mastercard";
    }
}
