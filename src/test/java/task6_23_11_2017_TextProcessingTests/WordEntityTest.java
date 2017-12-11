package task6_23_11_2017_TextProcessingTests;

import task6_23_11_2017_TextProcessing.entities.Word;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WordEntityTest {
    Word word;
    @Before
    public void init(){
        word=new Word(3,"saf");
    }

    @After
    public void tearDown(){
        word=null;
    }

    @Test
    public void NegativeVowelLettersShare()throws IllegalArgumentException{
        word.setVowelLettersShare(-1);
    }
}
