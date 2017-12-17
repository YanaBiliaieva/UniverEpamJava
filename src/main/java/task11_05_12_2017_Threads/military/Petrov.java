package task11_05_12_2017_Threads.military;

import static task11_05_12_2017_Threads.military.Main.*;

public class Petrov implements Runnable{
    @Override
    public void run() {
        System.out.println("Петров готов грузить имущество в грузовик");
        int count = 0;
        while (true) {
            synchronized (stolenValuables) {
                while (stolenValuables.length<0 && !stolen) {
                    System.out.println("Петров курит, пока нет оружия для погрузки.");
                    try {
                        stolenValuables.wait();
                    } catch (InterruptedException e) {
                        System.out.println("cannot start wait");
                    }
                }
                Valuables valuables = stolenValuables[count];
                count++;
                System.out.println("Петров загрузил "+count+" : " + valuables);
                synchronized (loadedValuables) {
                    loadedValuables[count]= valuables;
                    System.out.println("Петров кричит Нечепорчуку, что пора подсчитывать добычу.");
                    loadedValuables.notify();
                }
            }
            if (stolen && stolenValuables.length<0) {
                System.out.println("В грузовике " + count + " оружия");
                loaded = true;
                break;
            }
        }
    }
}
