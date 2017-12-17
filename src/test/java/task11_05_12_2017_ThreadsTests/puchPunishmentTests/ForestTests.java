package task11_05_12_2017_ThreadsTests.puchPunishmentTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import task11_05_12_2017_Threads.puchPunishment.Forest;

public class ForestTests {
    Forest forest;
    @Before
    public void init(){

        forest=new Forest(10,5);
    }
    @After
    public void tearDown(){

        forest=null;
    }
    @Test(expected = IllegalArgumentException.class)
    public void wrongLengthForestTest() {
        forest.setLength(0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void hideVinniInForestTest(){
        forest.hideVinniInForest(0);
    }
}
