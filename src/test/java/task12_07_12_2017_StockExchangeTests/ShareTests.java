package task12_07_12_2017_StockExchangeTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import task12_07_12_2017_Stock_Exchange.Share;

import static junit.framework.TestCase.assertTrue;

public class ShareTests {
    Share share;
    @Before
    public void init(){
        share =new Share("Coca-cola");
    }
    @After
    public void tearDown(){
        share =null;
    }
    @Test
    public void recalculatePriceTest() {
        boolean b=false;
        share.recalculatePrice();
        if(share.getPrice()>500)b=true;
        assertTrue(b);
    }
    @Test
    public void getPrice(){
        boolean b=false;
        if(share.getPrice()>0)b=true;
        assertTrue(b);
    }
    @Test
    public void getAmountOnStockTest(){
        boolean b=false;
        if(share.getAmountOnStock()>0)b=true;
        assertTrue(b);
    }
}
