package org.creditcard.models;

public abstract class CreditCard {
    private String cardNumber;
    private String expiryDate;
    private String cardHolderName;

    private String cardType;
    public CreditCard(String cardNumber, String expiryDate, String cardHolderName,String cardType) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cardHolderName = cardHolderName;
        this.cardType = cardType;
    }



    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
}

