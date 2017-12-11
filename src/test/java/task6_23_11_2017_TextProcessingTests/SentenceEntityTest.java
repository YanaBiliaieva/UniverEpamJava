package task6_23_11_2017_TextProcessingTests;
import task6_23_11_2017_TextProcessing.entities.Sentence;
import task6_23_11_2017_TextProcessing.entities.Word;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SentenceEntityTest {
    Sentence sentence;
    @Before
    public void init(){
        sentence=new Sentence(3,"saf");
    }

    @After
    public void tearDown(){
        sentence=null;
    }

    @Test
    public void NegativeVowelLettersShare()throws IllegalArgumentException{
        sentence.setVowelLettersShare(-1);
    }
}
