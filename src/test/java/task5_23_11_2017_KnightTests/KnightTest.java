package task5_23_11_2017_KnightTests;

import task5_16_11_2017_Knight.factory.KnightFactory;
import task5_16_11_2017_Knight.knight.Knight;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import task5_16_11_2017_Knight.utils.Name;

import static org.junit.Assert.assertTrue;

public class KnightTest {
    Knight knight;
    @Before
    public void init() {
        knight=new KnightFactory().createKnight();
    }
    @After
    public void tearDown() {
        knight=null;
    }
    @Test
    public void knightWrongAgeTest() {
        Boolean b=false;
        System.out.println(knight.getAge());
        if(knight.getAge()>18&&knight.getAge()<90){
            b=true;
        }
        assertTrue(b);
    }
    @Test
    public void knightWrongNameTest() {
        Boolean b=false;
        if(knight.getName()instanceof Name){
            b=true;
        }
        assertTrue(b);
    }
}
