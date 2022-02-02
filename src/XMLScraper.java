import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class XMLScraper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("First date:");
        String firstDate = scan.nextLine();
        System.out.println("Second date:");
        String secondDate= scan.nextLine();


        BestCurrency bc= new BestCurrency();
        try {
            bc.bestChoiceofCurrency(firstDate,secondDate);
        } catch (IOException e) {
            e.printStackTrace();
        }


      /*  System.out.println("How much currency do you have:");
        double currencyStock= scan.nextDouble();

        nodeTransactions nt = new nodeTransactions();
        NodeList a = null;
        Node b;
        try {
          a=  nt.getCurrencyNameList("01032021.xml");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO Exception");
        } catch (SAXException e) {
            e.printStackTrace();
            System.out.println("SAXException ");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            System.out.println("ParserConfigurationException");
        }

        for (int i = 1; i <a.getLength(); i++) {
            b=a.item(i);
            System.out.println(i+"=>"+b.getTextContent());

        }
        System.out.println("Currency type:");
        int currencyType=scan.nextInt();

        Finish last = new Finish();
        last.getDataProcessit(firstDate, secondDate, currencyStock, currencyType); */


    }
}
