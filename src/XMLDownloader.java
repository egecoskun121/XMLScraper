import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class XMLDownloader {


    public ArrayList<String> readDataFromURL(String urlz){
        URL url;
        String line = null;
        ArrayList<String> xml = new ArrayList<>();                // Reader for XML files.
        {
            try {
                url = new URL(urlz);
                URLConnection connection=url.openConnection();
                InputStream is=connection.getInputStream();
                BufferedReader br=new BufferedReader(new InputStreamReader(is));

                while ((line=br.readLine())!=null){
                    xml.add(line);

                }
                br.close();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
                e.getMessage();
            }
        }
        return xml;
    }

}
