package task12_07_12_2017_Stock_Exchange;

import java.util.ArrayList;
import java.util.Iterator;

public class TradeMarket implements Runnable{

    private ArrayList<Share> shareArrayList =new ArrayList<>();
    private volatile double currentIndex;
    private volatile double prevIndex;
    private double startIndex=500;
    private double startCapitalization;
    private final static double deltaIndex = 30;
    private boolean marketIsAlive = true;

    public double getStartCapitalization() {
        return startCapitalization;
    }

    public boolean marketIsAlive(){
        return marketIsAlive;
    }
    public void setMarketIsAlive(boolean b){
        marketIsAlive=b;
    }

    public Share getRandomObligation(){
        int index = (int)(Math.random()* shareArrayList.size());
        return shareArrayList.get(index);
    }

    public Iterator<Share> getPoolIterator(){//итератор текущего момента в листе
        return shareArrayList.iterator();
    }

    public synchronized void addShare(Share o){
        shareArrayList.add(o);
    }

    public void addShare(String companyName){
        this.addShare(new Share(companyName));
    }

    @Override
    public void run() {
        if (shareArrayList.size()<=0){
            try {
                throw new NoObligationException();
            } catch (NoObligationException e) {
                e.printStackTrace();
            }
            marketIsAlive=false;
            return;
        }
        calculateStartIndex();
        while (marketIsAlive){//каждый поток пересчитывает индекс раз в 15 секунд
            synchronized(shareArrayList){
                boolean continueTrades = recalculateIndex(prevIndex);
                if (!continueTrades) {
                    System.out.println("Индексы падают слишком быстро, останавливаем торги.");
                    marketIsAlive=false;
                    return;
                }
                shareArrayList.notifyAll();
                try {
                    shareArrayList.wait(15000);
                } catch (InterruptedException ex) {
                    System.out.println("Поток "+Thread.currentThread().getName()+" был прерван");
                }
            }
            if (Thread.interrupted()) return;
        }
    }
    public void calculateStartIndex(){
        synchronized(shareArrayList){
            for (Share o: shareArrayList){
                startCapitalization+=o.getPrice()*o.getAmountOnStock();
            }
        }
    }
    public boolean recalculateIndex(double prevIndex){ //пересчитываем индекс
        double currentCapitalization=0;
        synchronized(shareArrayList){
            for (Share o: shareArrayList){
                currentCapitalization+=o.getPrice()*o.getAmountOnStock();
            }
        }
        currentIndex = startIndex*(currentCapitalization/startCapitalization);//
        System.out.println("!!!--Текущий индекс рынка: "+currentIndex);
        boolean b=((prevIndex-currentIndex) <= deltaIndex);//если разница больше дельты, выдаем фолс
        System.out.println(b);
        return b;
    }

}