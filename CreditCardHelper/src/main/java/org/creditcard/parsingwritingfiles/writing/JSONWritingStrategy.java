package org.creditcard.parsingwritingfiles.writing;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.creditcard.models.OutPutCard;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class JSONWritingStrategy implements WritingStrategy{
    @Override
    public void writeCards(OutputStream output, List<OutPutCard> cards) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(output, cards);
    }
}
