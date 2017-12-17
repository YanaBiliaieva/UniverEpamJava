package task8_24_11_2017_StackCalculatorTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import task8_24_11_2017_StackCalculator.StackX;

import static org.junit.Assert.assertTrue;

public class StackXTest {
    StackX stackX;
    @Before
    public void init(){
        stackX = new StackX(20);
        stackX.push("2");
        stackX.push("+");
        stackX.push("3");
        stackX.push("-");
        stackX.push("1");
    }
    @After
    public void tearDown(){
        stackX =null;
    }
    @Test
    public void stackPopTest() throws Exception {
        stackX.pop();
        int currentSize= stackX.size();
        int expectedSize=4;
        assertTrue(currentSize == expectedSize);
    }

    @Test
    public void stackSizeTest() throws Exception {
        int currentSize= stackX.size();
        int expectedSize=5;
        assertTrue(currentSize == expectedSize);
    }

    @Test
    public void peekTest() throws Exception {
        String peek=stackX.peek();
        String expectedResult="1";
        System.out.println(peek);
        assertTrue(peek.equals(expectedResult));

    }

    @Test
    public void isEmptyTest() throws Exception {
        assertTrue(!stackX.isEmpty());
    }

}
