package org.creditcard.parsingwritingfiles.parsing;

import org.creditcard.models.Card;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XMLParsingStrategy implements ParsingStrategy{
    @Override
    public List<Card> parse(InputStream input) throws Exception {
        List<Card> creditCards = new ArrayList<>();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(input);
        doc.getDocumentElement().normalize();

        NodeList cardList = doc.getElementsByTagName("CARD");
        for (int i = 0; i < cardList.getLength(); i++) {
            Element cardElement = (Element) cardList.item(i);

            String cardNumber = getTagValue("CARD_NUMBER", cardElement);
            String expirationDate = getTagValue("EXPIRATION_DATE", cardElement);
            String cardHolderName = getTagValue("CARD_HOLDER_NAME", cardElement);

            creditCards.add(new Card(cardNumber, expirationDate, cardHolderName));
        }

        return creditCards;
    }

    private String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag);
        if (nodeList != null && nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent();
        }
        return null;
    }
}
