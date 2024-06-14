package org.creditcard.validation;

public class DiscoverValidation implements ValidationStrategy{
    @Override
    public boolean isValid(String cardNumber) {
        return cardNumber.startsWith("6011")
                && cardNumber.length() == 16
                && cardNumber.matches("\\d+");
    }

    @Override
    public String type(String card) {
        return "Discover";
    }
}
