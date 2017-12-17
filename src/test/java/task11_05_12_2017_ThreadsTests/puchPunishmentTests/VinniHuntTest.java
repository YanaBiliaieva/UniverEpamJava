package task11_05_12_2017_ThreadsTests.puchPunishmentTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import task11_05_12_2017_Threads.puchPunishment.AngryBee;
import task11_05_12_2017_Threads.puchPunishment.VinniHunt;

import static junit.framework.TestCase.assertTrue;

public class VinniHuntTest {
    VinniHunt vinniHunt;
    AngryBee angryBee1;

    @Before
    public void init(){

    }
    @After
    public void tearDown(){
        angryBee1=null;
        vinniHunt=null;
    }
    @Test
    public void vinniHuntTest()  {
        boolean b=false;
        vinniHunt=new VinniHunt();
        vinniHunt.setTheBearIsFound();
        AngryBee angryBee1 = new AngryBee(vinniHunt);
        Thread thread1 = new Thread(angryBee1);
        thread1.start();
        if(thread1.isAlive()==true) b=true;
        assertTrue(b);
    }
}
