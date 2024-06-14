package org.creditcard;

public class Main {
    public static void main(String[] args) {
        CreditCardProcess csvProcessor = new CreditCardProcess();
        CreditCardProcess jsonProcessor = new CreditCardProcess();
        CreditCardProcess xmlProcessor = new CreditCardProcess();

        String inputFilePathXML = "files/inputXML.xml";
        String outputFilePathXML = "files/outputXML.xml";

        String inputFilePathJSON = "files/inputJSON.json";
        String outputFilePathJSON = "files/outputJSON.json";

        String inputFilePathCSV = "files/inputCSV.csv";
        String outputFilePathCSV = "files/outputCSV.csv";

        try {
            csvProcessor.processCards(inputFilePathCSV,outputFilePathCSV);
            jsonProcessor.processCards(inputFilePathJSON,outputFilePathJSON);
            xmlProcessor.processCards(inputFilePathXML,outputFilePathXML);
            System.out.println("Processing completed successfully. Check the output file.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}