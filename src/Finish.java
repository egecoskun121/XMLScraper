import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class Finish {

    public void getDataProcessit(String dateFirst,String dateSecond,double currencyStock,int currencyType){

        XMLDownloader xmlDownloader = new XMLDownloader();
        Helper helper = new Helper();
        ArrayList<String[]> arrayListofDates= new ArrayList<>();
        String[] date=dateFirst.split("/");
        String[] date2=dateSecond.split("/");
        arrayListofDates.add(date);
        arrayListofDates.add(date2);
        String fileName= helper.fileNameBuilder(arrayListofDates,1);
        String fileName2= helper.fileNameBuilder(arrayListofDates,2);
        XMLWriter xmlWriter= new XMLWriter();
        XMLWriter xmlWriter1=new XMLWriter();
        try {
            xmlWriter.writeToXML(xmlDownloader, helper.finalURLBuilder(arrayListofDates,1), date[0],date[1],date[2]);
            xmlWriter1.writeToXML(xmlDownloader, helper.finalURLBuilder(arrayListofDates,2), date2[0],date2[1],date2[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }


        nodeTransactions gfs=new nodeTransactions();
        Node b;Node b2;Node s2;Node n2;Node s;Node n;
        Currency c1;
        Currency c2;
        try {
            if(xmlWriter.file.length()==0 || xmlWriter1.file.length()==0){
                System.out.println("One of the date's is invalid or stock market is closed that day.");

            }else {
                b2 = gfs.getSellPriceList(fileName2).item(currencyType - 1);
                s2 = gfs.getBuyPriceList(fileName2).item(currencyType - 1);
                b = gfs.getSellPriceList(fileName).item(currencyType - 1);
                s = gfs.getBuyPriceList(fileName).item(currencyType - 1);
                n2 = gfs.getCurrencyNameList(fileName2).item(currencyType - 1);
                n = gfs.getCurrencyNameList(fileName).item(currencyType - 1);
                c1 = new Currency(Double.parseDouble(b.getTextContent()), Double.parseDouble(s.getTextContent()), n.getTextContent());
                c2 = new Currency(Double.parseDouble(b2.getTextContent()), Double.parseDouble(s2.getTextContent()), n2.getTextContent());
                System.out.println(c1.calcDiff(currencyStock, c1.getBuyPrice(), c2.getSellPrice()) + " difference between prices in Turkish Lira");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

    }
}
