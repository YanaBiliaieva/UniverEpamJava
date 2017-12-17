package task8_24_11_2017_StackCalculatorTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import task8_24_11_2017_StackCalculator.ParseInfixToPostfix;

import static junit.framework.TestCase.assertTrue;

public class ParseInfixToPostfixTest {
    ParseInfixToPostfix trans;

    @Before
    public void init(){
        trans = new ParseInfixToPostfix("3*2");
    }
    @After
    public void tearDown(){
        trans=null;
    }
    @Test
    public void doTransTest() throws Exception {
        String result = trans.doTransform();
        String expected = " 3 2 *";
        assertTrue(expected.equals(result));
    }


}
