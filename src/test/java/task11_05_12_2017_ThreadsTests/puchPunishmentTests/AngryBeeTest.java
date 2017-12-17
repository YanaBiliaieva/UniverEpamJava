package task11_05_12_2017_ThreadsTests.puchPunishmentTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import task11_05_12_2017_Threads.puchPunishment.AngryBee;
import task11_05_12_2017_Threads.puchPunishment.VinniHunt;

import static junit.framework.TestCase.assertTrue;

public class AngryBeeTest {
    VinniHunt vinniHunt;
    AngryBee angryBee1;

    @Before
    public void init(){
        vinniHunt= new VinniHunt();
    }
    @After
    public void tearDown(){
        angryBee1=null;
        vinniHunt=null;
    }
    @Test
    public void wrongBeeCreationTest() {
        boolean b=false;
        angryBee1=new AngryBee(vinniHunt);
        if(angryBee1.beeId ==1)b=true;
        assertTrue(b);
    }

}