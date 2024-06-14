package org.creditcard;

import org.creditcard.cardfactory.CreditCardFactory;
import org.creditcard.cardfactory.CreditCardFactoryProvider;
import org.creditcard.models.Card;
import org.creditcard.models.CreditCard;
import org.creditcard.models.OutPutCard;
import org.creditcard.parsingwritingfiles.CardFileProcessorFactory;
import org.creditcard.parsingwritingfiles.parsing.ParsingStrategy;
import org.creditcard.parsingwritingfiles.writing.WritingStrategy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CreditCardProcess {
    public void processCards(String inputFilePath, String outputFilePath) throws IOException {
        String fileType = getFileExtension(inputFilePath);
        ParsingStrategy parser = CardFileProcessorFactory.getCardParser(fileType);
        WritingStrategy writer = CardFileProcessorFactory.getCardWriter(fileType);
        List<CreditCard> processedCards = new ArrayList<>();
        List<OutPutCard> outputCards = new ArrayList<>();

        try (InputStream input = new FileInputStream(inputFilePath);
             OutputStream output = new FileOutputStream(outputFilePath)) {
            List<Card> cards = parser.parse(input);
            for (Card card : cards) {
                CreditCardFactory factory = CreditCardFactoryProvider.getCreditCardFactory(card.getCardNumber());
                String type = CreditCardFactoryProvider.getCreditCardType(card.getCardNumber());
                CreditCard newCard = factory.createCreditCard(card.getCardNumber(), card.getExpiryDate(), card.getCardHolderName(),type);
                processedCards.add(newCard);
            }
            for (CreditCard card1 : processedCards){
                outputCards.add(new OutPutCard(card1.getCardNumber(),card1.getCardType()));
            }
            writer.writeCards(output, outputCards);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String getFileExtension(String fileName) {
        // Logic to extract file extension (json, xml, csv) from the file path
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex > 0) {
            return fileName.substring(dotIndex + 1);
        }
        throw new IllegalArgumentException("No extension found in file name: " + fileName);
    }
}
