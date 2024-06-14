package org.creditcard.parsingwritingfiles.parsing;

import org.creditcard.cardfactory.CreditCardFactory;
import org.creditcard.cardfactory.CreditCardFactoryProvider;
import org.creditcard.models.Card;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.creditcard.models.CreditCard;
import org.creditcard.models.JSONCard;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JSONParsingStrategy implements ParsingStrategy{
        @Override
        public List<Card> parse(InputStream input) throws Exception {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Card> myRealCards = new ArrayList<>();
            CardsWrapper wrapper = objectMapper.readValue(input, CardsWrapper.class);


            for (JSONCard card : wrapper.getCards()) {
                String number = card.getCardNumber();
                if (number == null){
                    number="";
                }

                myRealCards.add(new Card(number, card.getExpirationDate(), card.getCardHolderName()));
            }

            return myRealCards;
        }


    // Inner class for the JSON wrapper
    private static class CardsWrapper {
        private List<JSONCard> cards;

        public List<JSONCard> getCards() {
            return cards;
        }

        public void setCards(List<JSONCard> cards) {
            this.cards = cards;
        }
    }

}
