import java.util.ArrayList;

public class Helper {
    public String fileNameBuilder(ArrayList<String[]> arrayListofDates,int index){
        String fileName;
        return fileName=arrayListofDates.get(index -1)[0]+arrayListofDates.get(index -1)[1]+arrayListofDates.get(index-1)[2]+".xml";

    }
    public String finalURLBuilder(ArrayList<String[]> arrayListofDates,int index){
        String finalURL;
        return finalURL="https://www.tcmb.gov.tr/kurlar/"+arrayListofDates.get(index-1)[2]+arrayListofDates.get(index-1)[1]+
                "/"+arrayListofDates.get(index-1)[0]+
                arrayListofDates.get(index-1)[1]+arrayListofDates.get(index-1)[2]+".xml";
    }
}
