package task7_23_11_2017_URLFinderTests;

import task7_23_11_2017_URLFinder.FrequencyCounter;
import task7_23_11_2017_URLFinder.Main;
import task7_23_11_2017_URLFinder.URLFinder;
import task7_23_11_2017_URLFinder.exceptions.BadURLException;
import task7_23_11_2017_URLFinder.exceptions.NotEnoughURLException;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class URLFinderTestMockito {
    String mainURL="src/test/java/utils/mainHTML.html";

    @Test
    public void testFinderGetBodyFromURL() throws IOException, NotEnoughURLException, BadURLException {
        URL url=new File(mainURL).toURI().toURL();
        System.out.println(url.toString());
        URLFinder finder=new URLFinder();
        String content=finder.getBodyFromURL("file:/C:/Users/Admin/IdeaProjects/URLFinder/src/test/java/utils/mainHTML.html");
        //  create mock
        URLFinder urlFinder=mock(URLFinder.class);
        // define return value for method
        Mockito.when(urlFinder.getBodyFromURL("file:/C:/Users/Admin/IdeaProjects/URLFinder/src/test/java/utils/mainHTML.html")).thenReturn(content);
        // use mock in test....
        assertEquals(urlFinder.getBodyFromURL("file:/C:/Users/Admin/IdeaProjects/URLFinder/src/test/java/utils/mainHTML.html"), content);
        FrequencyCounter frequencyCounter=mock(FrequencyCounter.class);
        FrequencyCounter counter=new FrequencyCounter(Main.getExtractedUrls());
        HashMap<String,Integer> worldFrequency=counter.countWorldFrequency("file:/C:/Users/Admin/IdeaProjects/URLFinder/src/test/java/utils/mainHTML.html");
        Mockito.when(frequencyCounter.countWorldFrequency("file:/C:/Users/Admin/IdeaProjects/URLFinder/src/test/java/utils/mainHTML.html")).thenReturn(worldFrequency);

    }
    @Test
    public void testFinderExtractUrlsFromString() throws IOException, NotEnoughURLException {
        URLFinder urlFinder=mock(URLFinder.class);
        String content=urlFinder.getBodyFromURL("file:/C:/Users/Admin/IdeaProjects/URLFinder/src/test/java/utils/mainHTML.html");
        ArrayList<String> strings=urlFinder.extractUrlsFromString(content);
        Mockito.when(urlFinder.extractUrlsFromString(content)).thenReturn(strings);
        assertEquals(urlFinder.extractUrlsFromString(content), strings);

    }

}
