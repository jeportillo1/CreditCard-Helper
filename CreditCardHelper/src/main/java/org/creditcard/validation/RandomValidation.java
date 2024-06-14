package org.creditcard.validation;

import java.util.Objects;

public class RandomValidation implements ValidationStrategy{

    @Override
    public boolean isValid(String cardNumber) {
        boolean check1 = cardNumber.startsWith("4")
                && cardNumber.matches("\\d+")
                && (cardNumber.length() == 13
                || cardNumber.length() == 16);
        boolean check2 = cardNumber.startsWith("6011")
                && cardNumber.matches("\\d+")
                && cardNumber.length() == 16;
        boolean check3 = (cardNumber.startsWith("34")
                || cardNumber.startsWith("37"))
                && cardNumber.length() == 15
                && cardNumber.matches("\\d+");
        boolean check4 = cardNumber.startsWith("5")
                && (cardNumber.charAt(1) >= '1'
                && cardNumber.charAt(1) <= '5')
                && cardNumber.length() == 16
                && cardNumber.matches("\\d+");

        boolean decision = check1 || check2 || check3 || check4;

        return !decision;

    }

    @Override
    public String type(String card) {
        if (Objects.equals(card, "")) {
            return "Invalid: empty/null card number";
        } else if (!card.matches("\\d+")){
            return "Invalid: non numeric characters";
        } else if (card.length() > 19){
            return "Invalid: more than 19 digits";
        } else {
            return "Invalid: not a possible card";
        }
    }
}
