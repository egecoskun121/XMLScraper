import org.w3c.dom.Node;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BestCurrency {
    public void bestChoiceofCurrency(String dateFirst,String dateSecond) throws IOException {

        LocalDate FD=LocalDate.parse(dateFirst, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate SD=LocalDate.parse(dateSecond, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        XMLDownloader xmlDownloader= new XMLDownloader();
        ArrayList<String []> arrayListofDates= new ArrayList<>();
        Helper helper = new Helper();
        int i =1;
        nodeTransactions nts = new nodeTransactions();

        for(LocalDate FD1=FD;FD.isBefore(SD);FD=FD.plusDays(1)){                  // Downloader for XML files between given dates
            XMLWriter xmlWriter = new XMLWriter();
            String day,month,year;
            String [] dates=new String[3];
            if(FD.getDayOfMonth()<10){
                day = "0"+String.valueOf(FD.getDayOfMonth());}
            else{day=String.valueOf(FD.getDayOfMonth());
            };
            year= String.valueOf(FD.getYear());
            if(FD.getMonthValue()<10){month="0"+String.valueOf(FD.getMonthValue());}else {
                month= String.valueOf(FD.getMonthValue());
            }

            dates[0]=day;
            dates[1]=month;
            dates[2]=year;
            arrayListofDates.add(dates);
            xmlWriter.writeToXML(xmlDownloader,helper.finalURLBuilder(arrayListofDates,i),day,month,year);
            if(!xmlWriter.file.exists()){
                System.out.println("Stock market closed date =>"+day+"-"+month+"-"+year);
            }

            i++;
        }


    }

}
