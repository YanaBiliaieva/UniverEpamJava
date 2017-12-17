package task12_07_12_2017_StockExchangeTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import task12_07_12_2017_Stock_Exchange.Broker;
import task12_07_12_2017_Stock_Exchange.Share;
import task12_07_12_2017_Stock_Exchange.TradeMarket;

import java.util.ArrayList;
import java.util.Iterator;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class TradeMarketTest {
    Broker broker;
    TradeMarket workingMarket;
    Share share;
    ArrayList<Share> shareArrayList;
    @Before
    public void init(){
        workingMarket=new TradeMarket();
        workingMarket.addShare("Кока-кола");
        broker=new Broker(workingMarket);
        shareArrayList =new ArrayList<>();
    }
    @After
    public void tearDown(){
        workingMarket=null;
        broker=null;
    }
    @Test
    public void getRandomShareTest(){
        boolean b=false;
        share =workingMarket.getRandomObligation();
        if(share instanceof Share)b=true;
        assertTrue(b);
    }
    @Test
    public void getPoolIterator(){
        boolean b=false;
        Iterator<Share> iterator=workingMarket.getPoolIterator();
       if(iterator instanceof Iterator)b=true;
        assertTrue(b);
    }
    @Test
    public void calculateStartIndexTest(){
        workingMarket.calculateStartIndex();
        double v=workingMarket.getStartCapitalization();
        double expectedResult=250000.0;
        assertTrue(v==expectedResult);
    }
    @Test
    public void recalculateIndexTest(){
        boolean v=workingMarket.recalculateIndex(1);
        boolean expectedResult=true;
        assertTrue(v==expectedResult);
    }
}
