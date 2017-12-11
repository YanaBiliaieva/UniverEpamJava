package task7_23_11_2017_URLFinder;

import task7_23_11_2017_URLFinder.exceptions.BadURLException;
import task7_23_11_2017_URLFinder.exceptions.InputIsNotWordException;
import task7_23_11_2017_URLFinder.exceptions.NotEnoughURLException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Biliaieva Yana
 * Task: написать поисковый сервис:
 * по произвольному URL перейти и спомощью регулярного выражения найти 20 URL
 * к каждому URL указывать ключевые слова с частой встречаемости
 * по указаному слову найти все URL упорядоченые по возрастанию частоты слова
 */
public class Main {
    private static String startUrl="https://en.wikipedia.org/wiki/Template_method_pattern";

    public static ArrayList<String> extractedUrls;
    public static FrequencyCounter counter;
    public static ArrayList<String> getExtractedUrls() {
        return extractedUrls;
    }

    public static FrequencyCounter getCounter() {
        return counter;
    }

    public static void main(String[] args) throws IOException, NotEnoughURLException, InputIsNotWordException, BadURLException {
        URLFinder urlFinder=new URLFinder();
        extractedUrls =urlFinder.extractUrlsFromString(urlFinder.getBodyFromURL(startUrl));
        System.out.println("List of URL:"+extractedUrls);
        //FrequencyCounter counter=new FrequencyCounter(extractedUrls);
        counter=new FrequencyCounter(Main.getExtractedUrls());
        //по указаному слову найти все URL упорядоченые по возрастанию частоты слова
        System.out.println("Enter word for search through urls:");
        while(true) {//BufferedReader
                    Scanner scan = new Scanner(System.in);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();
                    String word = scan.nextLine();
                    System.out.println("String word="+word);
                   if(word.matches("^[a-zA-Z ]*$")){
                       HashMap<String, Integer> searchResult=urlFinder.searchEnteredWord(word);
                       if(!searchResult.isEmpty()){
                           System.out.println("searchResult"+searchResult);
                       }else{
                           System.out.println("Word not found");
                       }
                   }else{
                       System.out.println("Not a word!");
                        //throw new InputIsNotWordException("Input is not word");
                  }
        }
    }
}
