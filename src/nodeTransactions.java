import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class nodeTransactions {

    public NodeList getSellPriceList(String xmlname) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder=factory.newDocumentBuilder();
        Document doc = builder.parse(xmlname);
        NodeList currencySellPriceList=doc.getElementsByTagName("ForexSelling");

        return currencySellPriceList;
    }
    public NodeList getCurrencyNameList(String xmlname) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
        Document doc = builder.parse(xmlname);
        NodeList currencyNameList=doc.getElementsByTagName("CurrencyName");

        return currencyNameList;
    }
    public NodeList getBuyPriceList(String xmlname) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
        Document doc = builder.parse(xmlname);
        NodeList currencyBuyPriceList=doc.getElementsByTagName("ForexBuying");

        return currencyBuyPriceList;
    }
}
