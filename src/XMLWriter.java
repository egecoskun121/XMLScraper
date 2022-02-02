import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class XMLWriter {
    File file;
    public void writeToXML(XMLDownloader xmlReader, String urlz,String day,String month,String year) throws IOException {

        FileWriter writer = null;
        BufferedWriter bw = null;

        file = new File(day+month+year+".xml");
        if(!file.exists()) {
            writer = new FileWriter(file);

            bw = new BufferedWriter(writer);
            for (int i = 0; i < xmlReader.readDataFromURL(urlz).size(); i++) {
                bw.write(xmlReader.readDataFromURL(urlz).get(i));
                bw.newLine();
            }
            bw.close();

        }else System.out.println("File already exists");

    }

}

