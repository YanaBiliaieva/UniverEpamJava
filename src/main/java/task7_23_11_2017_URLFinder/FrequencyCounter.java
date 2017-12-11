package task7_23_11_2017_URLFinder;

import task7_23_11_2017_URLFinder.exceptions.BadURLException;
import task7_23_11_2017_URLFinder.exceptions.NotEnoughURLException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FrequencyCounter {
    public HashMap<String,HashMap<String, Integer>> worldsFrequencyInUrls;

    public HashMap<String, HashMap<String, Integer>> getWorldsFrequencyInUrls() {
        return worldsFrequencyInUrls;
    }

    public FrequencyCounter(ArrayList<String> urlList) throws IOException, NotEnoughURLException, BadURLException {
        worldsFrequencyInUrls=new HashMap<String,HashMap<String, Integer>>();
        for (int i = 0;  i < urlList.size()&&i<20; i++) {
            System.out.println("№"+(i+1)+". Words frequency for URL "+urlList.get(i)+":");
            HashMap<String,Integer> wordsFrequency=countWorldFrequency(urlList.get(i));
            worldsFrequencyInUrls.put(urlList.get(i),wordsFrequency);
            Map.Entry<String, Integer> maxEntry = null;
            for (Map.Entry<String, Integer> entry : wordsFrequency.entrySet()){
                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                    if(entry.getKey()!="null"){
                        maxEntry = entry;
                    }
                }
            }
            System.out.println("More frequent word in"+urlList.get(i)+": "+maxEntry.getKey()+" "+maxEntry.getValue());
        }

    }
    public HashMap<String,Integer> countWorldFrequency(String url) throws IOException, NotEnoughURLException, BadURLException {
        HashMap<String,Integer> wordsFrequency=new HashMap<String, Integer>();
        String[] words = getWordsFromURL(url);
        if(words!=null){
            for(String word : words){
                if(wordsFrequency.containsKey(word)&&(word!=null)){
                    wordsFrequency.put(word, wordsFrequency.get(word)+1);
                }
                else if(word!=null){
                    wordsFrequency.put(word, 1);
                }
            } System.out.println(wordsFrequency);
        }

        return wordsFrequency;
    }
    public String[] getWordsFromURL(String mainUrl) throws IOException, NotEnoughURLException, BadURLException {
        URL url=new URL(mainUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
        String[] words;
        if (con.getResponseCode() != HttpURLConnection.HTTP_OK) {
           return null;
        }else {
            String inputLine;
            StringBuilder pageContent = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                pageContent.append(inputLine);
            }
            in.close();
            String content = pageContent.toString();
            Pattern removeTags = Pattern.compile("<.+?>");
            Matcher m = removeTags.matcher(content);
            content = m.replaceAll("");
            content = content.toLowerCase().replaceAll("[^a-z ]", "");
            words = content.split(" ");
            words = Arrays.stream(words)
                    .filter(s -> (s != null && s.length() > 0))
                    .toArray(String[]::new);
        }
        return words;
    }
}
