package org.creditcard.parsingwritingfiles.parsing;

import com.opencsv.CSVReader;
import org.creditcard.models.AmExCC;
import org.creditcard.models.Card;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVParsingStrategy implements ParsingStrategy{
    @Override
    public List<Card> parse(InputStream input) throws Exception {
        List<Card> cards = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new InputStreamReader(input))) {
            String[] values;
            while ((values = csvReader.readNext()) != null) {
                if (values.length >= 3) {
                    String cardNumber = values[0];
                    String expiryDate = values[1];
                    String cardHolderName = values[2];
                    cards.add(new Card(cardNumber, expiryDate, cardHolderName));
                }
            }
        }

        return cards;
    }
}
