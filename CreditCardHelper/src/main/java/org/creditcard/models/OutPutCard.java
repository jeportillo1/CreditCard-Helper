package org.creditcard.models;

public class OutPutCard {
    private String cardNumber;
    private String cardType;

    public OutPutCard(String cardNumber, String cardType) {
        this.cardNumber = cardNumber;
        this.cardType = cardType;
    }


    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

}
