package task6_23_11_2017_TextProcessingTests;
import task6_23_11_2017_TextProcessing.app.Main;
import task6_23_11_2017_TextProcessing.entities.Word;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.NoSuchFileException;

public class readFileTest {
    String path;
    @Before
    public void init() {
    path="src/main/java/resource/teext.txt";

    }   @After
    public void tearDown(){
        path=null;
    }

    @Test(expected = IOException.class)
    public void readWrongPath() throws IOException {
        String s=Main.readFile(path, StandardCharsets.UTF_8);
    }
}
