package task8_24_11_2017_StackCalculatorTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import task8_24_11_2017_StackCalculator.CannotParseException;
import task8_24_11_2017_StackCalculator.ParsePost;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//2.5
public class ParsePostTest {
    ParsePost parsePost;
    @Before
    public void init() {
        parsePost=new ParsePost("2 3 +");
    }
    @After
    public void tearDown(){
        parsePost=null;
    }

    @Test
    public void trueArgumentsParse() throws CannotParseException {
       Double result=parsePost.doParse();
       System.out.println("result="+result);
       double expected=5.0;
       assertTrue(result==expected);
    }
}
