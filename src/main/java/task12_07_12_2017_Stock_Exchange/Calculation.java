package task12_07_12_2017_Stock_Exchange;

import java.util.Iterator;

public class Calculation implements Runnable {
    private TradeMarket workingMarket;

    public Calculation(TradeMarket workingMarket) {
        this.workingMarket = workingMarket;
    }

    @Override
    public void run() {
        while (workingMarket.marketIsAlive()) {
            Iterator iter = workingMarket.getPoolIterator();
            while (iter.hasNext()) {
                Share o = (Share) iter.next();
                synchronized (o) {
                    o.recalculatePrice();
                }
            }
            int sleepTime = (int) (Math.random() * 10000);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException ex) {
                return;
            }
            if (Thread.interrupted()) return;
        }
    }
}