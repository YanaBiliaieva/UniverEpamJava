package task7_23_11_2017_URLFinderTests;

import task7_23_11_2017_URLFinder.FrequencyCounter;
import task7_23_11_2017_URLFinder.Main;
import task7_23_11_2017_URLFinder.exceptions.BadURLException;
import task7_23_11_2017_URLFinder.exceptions.NotEnoughURLException;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.mockito.Mockito.mock;

public class FrequencyCounterTest {
    @Test
    public void counterCountWorldFrequencyTest() throws BadURLException, IOException, NotEnoughURLException {
        FrequencyCounter frequencyCounter=mock(FrequencyCounter.class);
        FrequencyCounter counter=new FrequencyCounter(Main.getExtractedUrls());
        HashMap<String,Integer> worldFrequency=counter.countWorldFrequency("file:/C:/Users/Admin/IdeaProjects/URLFinder/src/test/java/utils/mainHTML.html");
        Mockito.when(frequencyCounter.countWorldFrequency("file:/C:/Users/Admin/IdeaProjects/URLFinder/src/test/java/utils/mainHTML.html")).thenReturn(worldFrequency);
    }
    @Test
    public void counterGetWordsFromURL() throws BadURLException, IOException, NotEnoughURLException {
        FrequencyCounter frequencyCounter=mock(FrequencyCounter.class);
        FrequencyCounter counter=new FrequencyCounter(Main.getExtractedUrls());
        String[] words=counter.getWordsFromURL("file:/C:/Users/Admin/IdeaProjects/URLFinder/src/test/java/utils/mainHTML.html");
        Mockito.when(frequencyCounter.getWordsFromURL("file:/C:/Users/Admin/IdeaProjects/URLFinder/src/test/java/utils/mainHTML.html")).thenReturn(words);
    }
}
