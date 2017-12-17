package task12_07_12_2017_Stock_Exchange;

/**
 * @author Yana Biliaieva
 * @task Разработать многопоточное приложение. Все сущности, желающие получить доступ к ресурсу, должны быть потоками. Использовать возможности ООП.
 * 7. Биржа. На торгах брокеры предлагают акции нескольких фирм.
 * На бирже совершаются действия по купле-продаже акций. В зависимости от количества проданных-купленных акций их цена изменяется.
 * Брокеры предлагают к продаже некоторую часть акций. От активности и роста-падения котировок акций изменяется индекс биржи.
 * Биржа может приостановить торги при резком падении индекса.
 *
 */
public class Main {
    public static void main(String[] args) {
        TradeMarket tm = new TradeMarket();
        tm.addShare("Кока-кола");
        tm.addShare("Пепси");
        tm.addShare("Лэйс");
        tm.addShare("7Ап");
        tm.addShare("Юппи");
        new Thread(tm).start(); //запускаем рынок

        new Thread(new Calculation(tm)).start(); //запускаем калькулятор цен

        int brokerCount = (int)(Math.random()*10);
        for (int i=0;i<brokerCount;i++){//создаем брокеров, даем брокеру номер к имени
            new Thread(new Broker(tm),"Брокер_"+i).start();
        }

        try {
            Thread.sleep(1000);//достаточно долго, чтобы увидеть, как рынок работает
        } catch (InterruptedException ex) {
            System.out.println("the thread was interrupted");
        }

    }
}
