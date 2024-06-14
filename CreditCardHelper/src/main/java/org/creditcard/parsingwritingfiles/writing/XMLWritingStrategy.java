package org.creditcard.parsingwritingfiles.writing;

import org.creditcard.models.OutPutCard;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class XMLWritingStrategy implements WritingStrategy{
    @Override
    public void writeCards(OutputStream output, List<OutPutCard> cards) throws IOException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(OutPutCardsWrapper.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            OutPutCardsWrapper wrapper = new OutPutCardsWrapper();
            wrapper.setCards(cards);
            marshaller.marshal(wrapper, output);
        } catch (Exception e) {
            throw new IOException("Error writing XML", e);
        }
    }

    @XmlRootElement(name = "cards")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class OutPutCardsWrapper {
        private List<OutPutCard> cards;

        // Getter
        public List<OutPutCard> getCards() {
            return cards;
        }

        // Setter
        public void setCards(List<OutPutCard> cards) {
            this.cards = cards;
        }
    }

}
