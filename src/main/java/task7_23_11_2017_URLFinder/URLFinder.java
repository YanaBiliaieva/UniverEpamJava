package task7_23_11_2017_URLFinder;

import task7_23_11_2017_URLFinder.exceptions.BadURLException;
import task7_23_11_2017_URLFinder.exceptions.NotEnoughURLException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLFinder {
    public static FrequencyCounter counter;
    public ArrayList<String> extractUrlsFromString(String content) throws NotEnoughURLException, IOException {
        ArrayList<String> result = new ArrayList<String>();
        String regex = "(https?|http)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(content);
        while (m.find()) {
            URL url=new URL(m.group());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            if (con.getResponseCode() == HttpURLConnection.HTTP_OK){
                result.add(m.group());
            }
        }
        if(result.size()>20)
            return result;
        else {
            System.out.println(result.size());
            throw new NotEnoughURLException("There is less then 20 URLs");
        }
    }
    public String getBodyFromURL(String Url) throws IOException, NotEnoughURLException {
        System.out.println(Url);
        URL url=new URL(Url);
        URLConnection con = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
        String inputLine;
        StringBuilder pageContent = new StringBuilder();
        while ((inputLine = in.readLine()) != null){
            pageContent.append(inputLine);
        } in.close();
        String content=pageContent.toString();
        return content;
    }
    public HashMap<String, Integer> searchEnteredWord(String word) throws BadURLException, IOException, NotEnoughURLException {

        HashMap<String,HashMap<String, Integer>> worldsFrequencyInUrls =Main.getCounter().getWorldsFrequencyInUrls();

        HashMap<String, Integer> searchResult=new HashMap<>();
        Integer resultCounter;
        for (Map.Entry<String, HashMap<String, Integer>> entry : worldsFrequencyInUrls.entrySet()) {
            String itemKey = entry.getKey();
            //System.out.println("itemKey="+itemKey);
            for (Map.Entry<String, Integer> innerEntry : entry.getValue().entrySet()) {
                //System.out.println("innerEntry.getKey()="+innerEntry.getKey()+" word="+word+"Equals:"+(innerEntry.getKey()==word));
                if(innerEntry.getKey().equals(word)){
                    //System.out.println("itemKey="+itemKey+"resultCounter"+innerEntry.getValue());
                    resultCounter=innerEntry.getValue();
                    searchResult.put(itemKey,resultCounter);
                }
            }
        }return searchResult;
    }
}
