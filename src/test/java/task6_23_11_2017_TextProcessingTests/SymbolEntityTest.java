package task6_23_11_2017_TextProcessingTests;
import task6_23_11_2017_TextProcessing.entities.Symbol;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SymbolEntityTest {
    Symbol symbol;
    @Before
    public void init(){
        symbol=new Symbol(2,'k');
    }
    @After
    public void tearDown(){
        symbol=null;
    }
    @Test
    public void NegativeVowelLettersShare() throws IllegalArgumentException{
        symbol.setVowelLettersShare(-1);
    }
}
