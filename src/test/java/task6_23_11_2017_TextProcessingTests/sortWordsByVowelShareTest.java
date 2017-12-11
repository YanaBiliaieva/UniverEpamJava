package task6_23_11_2017_TextProcessingTests;
import task6_23_11_2017_TextProcessing.app.Main;
import task6_23_11_2017_TextProcessing.entities.Word;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class sortWordsByVowelShareTest {
    Word[] words;
    Word[] sortedWords;
    Word[] resultWords;
    @Before
    public void init(){
        words=new Word[]{new Word(0,"sdf"),
                new Word(3,"jnaa"),
                new Word(0,"sdf"),
                new Word(3,"jnooo")};
        sortedWords=new Word[]{new Word(0,"sdf"),
                new Word(0,"sdf"),
                new Word(3,"jnaa"),
                new Word(3,"jnooo")};
    }
    @After
    public void  tearDown(){
        words=null;
        resultWords=null;
        sortedWords=null;
    }
    @Test
    public void wordsSortTest(){
        boolean b=false;
        resultWords=Main.sortWordsByVowelShare(words);
        for (int i = 0; i <resultWords.length; i++) {
            if(resultWords[i].getVowelLettersShare()==sortedWords[i].getVowelLettersShare()){
                b=true; continue;
            }else {
                b=false;break;
            }
        }
        assertTrue(b);
    }
}
