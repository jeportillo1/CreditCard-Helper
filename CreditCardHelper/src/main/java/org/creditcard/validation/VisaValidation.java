package org.creditcard.validation;

public class VisaValidation implements ValidationStrategy{
    @Override
    public boolean isValid(String cardNumber) {
        return cardNumber.startsWith("4") && cardNumber.matches("\\d+")
                && (cardNumber.length() == 13
                || cardNumber.length() == 16);
    }

    @Override
    public String type(String card) {
        return "Visa";
    }
}
