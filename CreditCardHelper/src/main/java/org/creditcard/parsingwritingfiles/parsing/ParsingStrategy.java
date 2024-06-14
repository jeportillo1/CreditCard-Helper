package org.creditcard.parsingwritingfiles.parsing;

import org.creditcard.models.Card;

import java.io.InputStream;
import java.util.List;

public interface ParsingStrategy {
    List<Card> parse(InputStream input) throws Exception;
}
