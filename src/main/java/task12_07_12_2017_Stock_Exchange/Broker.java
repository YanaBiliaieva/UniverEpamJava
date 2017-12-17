package task12_07_12_2017_Stock_Exchange;

import java.util.HashMap;
import java.util.Iterator;

public class Broker implements Runnable {
    private TradeMarket workingMarket;
    HashMap<Share, Integer> obligationsCount = new HashMap<>();


    public Broker(TradeMarket workingMarket) {
        this.workingMarket = workingMarket;
        Iterator iter = workingMarket.getPoolIterator();
        while (iter.hasNext()) {
            obligationsCount.put((Share) iter.next(), 0); //сколько осталось облигаций у каждого брокера
        }
    }

    @Override
    public void run()  {
        while (workingMarket.marketIsAlive()) {
            Share share = workingMarket.getRandomObligation();
            int byOrSell = (int) (Math.random() * 2); //рандомно определяем, что будут делать брокеры

            System.out.println("Брокер " + Thread.currentThread().getName() + " будет покупать или продавать: " + byOrSell);
            synchronized (share) {
                int obligationsToBuySell = (int) (Math.random() * 10); // пытаются купить или продать до 10 облигаций
                int obligationsOnHands = obligationsCount.get(share);
                int obligationsOnMarket = share.getAmountOnStock();
                if (byOrSell >= 1) { //если больше 1 будут продавать
                    System.out.println("Брокер" + Thread.currentThread().getName() + " будет продавать");
                    if (obligationsToBuySell <= obligationsOnHands) {//если у него есть столько, сколько выпало рандомно
                        obligationsCount.put(share, obligationsOnHands - obligationsToBuySell);
                        share.incrementSalesCount();
                        share.setAmountOnStock(obligationsToBuySell + obligationsOnMarket);
                        System.out.println("Брокер " + Thread.currentThread().getName() + " только что продал " + obligationsToBuySell +
                                " облигации компании " + share.getCompanyName());
                    } else { //если у него нет столько облигаций, сколько выпало рандомно
                        System.out.println("Брокер " + Thread.currentThread().getName() + " попытался продать " + obligationsToBuySell +
                                " облигации компании " + share.getCompanyName() + " , но у него их не хватило.");
                    }
                } else {//если меньше, покупать
                    System.out.println("Брокер" + Thread.currentThread().getName() + " будет покупать");
                    if (obligationsToBuySell <= obligationsOnMarket) {//если облигаций на рынке больше, чем нужно купить, можно покупать
                        obligationsCount.put(share, obligationsOnHands + obligationsToBuySell);
                        share.incrementBuysCount();
                        share.setAmountOnStock(obligationsOnMarket - obligationsToBuySell);
                        System.out.println("Брокер " + Thread.currentThread().getName() + " только что купил " + obligationsToBuySell +
                                " облигации компании " + share.getCompanyName());
                    } else {//облигаций на рынке не хватает
                        System.out.println("Брокер " + Thread.currentThread().getName() + " попытался купить " + obligationsToBuySell +
                                " облигации компании " + share.getCompanyName() + " но на рынке не хватает этих облигаций");
                    }
                }
            }
            int waitingTime = (int) (Math.random() * 15000);
            try {
                Thread.sleep(waitingTime);
            } catch (InterruptedException ex) {
                return;
            }
            if (Thread.interrupted()) return;
        }if(workingMarket.marketIsAlive()==false) new MarketIsNotAliveException();

    }
}
