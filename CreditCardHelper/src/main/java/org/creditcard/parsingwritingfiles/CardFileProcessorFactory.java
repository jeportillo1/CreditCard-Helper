package org.creditcard.parsingwritingfiles;

import org.creditcard.parsingwritingfiles.parsing.CSVParsingStrategy;
import org.creditcard.parsingwritingfiles.parsing.JSONParsingStrategy;
import org.creditcard.parsingwritingfiles.parsing.ParsingStrategy;
import org.creditcard.parsingwritingfiles.parsing.XMLParsingStrategy;
import org.creditcard.parsingwritingfiles.writing.CSVWritingStrategy;
import org.creditcard.parsingwritingfiles.writing.JSONWritingStrategy;
import org.creditcard.parsingwritingfiles.writing.WritingStrategy;
import org.creditcard.parsingwritingfiles.writing.XMLWritingStrategy;

public class CardFileProcessorFactory {
    public static ParsingStrategy getCardParser(String fileType) {
        switch (fileType.toLowerCase()) {
            case "json":
                return new JSONParsingStrategy();
            case "xml":
                return new XMLParsingStrategy();
            case "csv":
                return new CSVParsingStrategy();
            default:
                throw new IllegalArgumentException("Unsupported file type: " + fileType);
        }
    }

    public static WritingStrategy getCardWriter(String fileType) {
        switch (fileType.toLowerCase()) {
            case "json":
                return new JSONWritingStrategy();
            case "xml":
                return new XMLWritingStrategy();
            case "csv":
                return new CSVWritingStrategy();
            default:
                throw new IllegalArgumentException("Unsupported file type: " + fileType);
        }
    }
}
