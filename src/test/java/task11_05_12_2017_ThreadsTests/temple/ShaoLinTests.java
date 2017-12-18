package task11_05_12_2017_ThreadsTests.temple;
import org.junit.Before;
import org.junit.Test;
import task11_05_12_2017_Threads.shaoLin.Monk;

import static org.junit.Assert.assertEquals;

public class ShaoLinTests {
    Monk monk;
    int[] moncksEnergyArray;
    @Before
    public void init() {
        monk = new Monk(0,1);
        moncksEnergyArray=new int[2];
    }

    @Test
    public void battle(){
        moncksEnergyArray[1]=11;
        moncksEnergyArray[2]=12;
        int winner=monk.getWinnerBetweenTwo(1,2);
        assertEquals(moncksEnergyArray[2],winner);
    }

}