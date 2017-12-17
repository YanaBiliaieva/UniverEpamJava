package task11_05_12_2017_Threads.military;

import static task11_05_12_2017_Threads.military.Main.*;

public class Nechiporchuk implements Runnable {
    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (loadedValuables) {
                while (loadedValuables.length<0 && !loaded) {
                    try {
                        loadedValuables.wait();
                    } catch (InterruptedException e) {
                        System.out.println("cannot start wait");
                    }
                }
                Valuables valuables = loadedValuables[count];
                count++;
                System.out.println("Нечипорчук подсчитал:" + totalPrice + "+" +  valuables.getPrice() + "=" +  (totalPrice + valuables.getPrice()) );
                totalPrice += valuables.getPrice();
                countedValuables[count]= valuables;
            }
            if (loaded && loadedValuables.length<0) {
                counted = true;
                price = totalPrice;
                System.out.println("На данный момент в грузовике оружия " + count+"на сумму " + totalPrice);
                counted = true;
                break;
            }
        }
    }
}
