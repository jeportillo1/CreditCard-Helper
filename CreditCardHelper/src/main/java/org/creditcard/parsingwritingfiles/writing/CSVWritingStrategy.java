package org.creditcard.parsingwritingfiles.writing;

import com.opencsv.CSVWriter;
import org.creditcard.models.OutPutCard;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CSVWritingStrategy implements WritingStrategy{
    @Override
    public void writeCards(OutputStream output, List<OutPutCard> cards) throws IOException {
        try (CSVWriter writer = new CSVWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8))) {
            // Write header
            writer.writeNext(new String[]{"Card Number", "Card Type"});

            // Write each card's data
            for (OutPutCard card : cards) {
                writer.writeNext(new String[]{
                        card.getCardNumber(),
                        card.getCardType()
                });
            }
        }
    }
}
