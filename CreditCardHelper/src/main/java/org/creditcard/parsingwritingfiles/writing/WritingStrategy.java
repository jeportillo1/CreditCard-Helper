package org.creditcard.parsingwritingfiles.writing;

import org.creditcard.models.OutPutCard;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public interface WritingStrategy {
    void writeCards(OutputStream output, List<OutPutCard> cards) throws IOException;
}
