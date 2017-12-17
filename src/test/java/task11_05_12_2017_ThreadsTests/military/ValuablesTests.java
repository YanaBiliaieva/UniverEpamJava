package task11_05_12_2017_ThreadsTests.military;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import task11_05_12_2017_Threads.military.Valuables;

public class ValuablesTests {
    Valuables valuables;
    @Before
    public void init(){
        valuables = valuables.create();
    }
    @After
    public void tearDown(){
        valuables =null;
    }
    @Test
    public void getInstance() {
        Valuables valuables = Valuables.create();
        System.out.println(valuables);
    }
    @Test(expected = IllegalArgumentException.class)
    public void setWrongPrice(){
        valuables.setPrice(-1);
    }
}
