package task12_07_12_2017_StockExchangeTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import task12_07_12_2017_Stock_Exchange.Broker;
import task12_07_12_2017_Stock_Exchange.TradeMarket;

public class BrokerTest {
    Broker broker;
    TradeMarket workingMarket;
    @Before
    public void init(){
        workingMarket=new TradeMarket();
        workingMarket.addShare("Кока-кола");
        broker=new Broker(workingMarket);

    }
    @After
    public void tearDown(){
        workingMarket=null;
        broker=null;
    }
    @Test
    public void brokerRunTest()  {
        workingMarket.setMarketIsAlive(false);
        broker.run();
    }
}
