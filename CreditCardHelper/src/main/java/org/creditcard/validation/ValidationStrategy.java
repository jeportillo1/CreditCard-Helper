package org.creditcard.validation;

public interface ValidationStrategy {
    boolean isValid(String cardNumber);

    String type(String card);
}
