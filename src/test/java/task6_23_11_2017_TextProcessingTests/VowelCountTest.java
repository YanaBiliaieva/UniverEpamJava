package task6_23_11_2017_TextProcessingTests;
import task6_23_11_2017_TextProcessing.app.Main;
import task6_23_11_2017_TextProcessing.entities.Word;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VowelCountTest {
    String[] words;
    @Before
    public void init(){
        words=new String[]{"de","dsfe", "sdfd"};
    }

    @After
    public void tearDown(){
        words=null;
    }

    @Test
    public void countVowelsShareInStringTest(){
        Word[] wordArray = Main.vowelCount(words);
        boolean b=false;
        if((wordArray[0].getVowelLettersShare()==50)&&
                (wordArray[1].getVowelLettersShare()==25)&&
                (wordArray[2].getVowelLettersShare()==0)){
            b=true;
        }
        Assert.assertTrue(b);
    }
}
