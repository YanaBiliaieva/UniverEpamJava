package task8_24_11_2017_StackCalculatorTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import task8_24_11_2017_StackCalculator.CannotParseException;
import task8_24_11_2017_StackCalculator.PostfixApp;

public class PostfixAppTest {

    @Test
    public void assertCorrectResult() throws CannotParseException {
        double computedResult=PostfixApp.computeExpression("44+8-9*8");
        double expectedResult=-20.0;
        assertTrue(computedResult==expectedResult);
    }
    @Test
    public void assertCorrectResultWithSin() throws CannotParseException {
        double computedResult=PostfixApp.computeExpression("cos44+8-9*8");
        double expectedResult=-63.00015669135231;
        assertTrue(computedResult==expectedResult);
    }
    @Test
    public void assertCorrectResultWithBrackets() throws CannotParseException {
        double computedResult=PostfixApp.computeExpression("(cos44+8-9)*8");
        double expectedResult=-0.0012535308184737914;
        assertTrue(computedResult==expectedResult);
    }
}
