package task11_05_12_2017_Threads.military;

import static task11_05_12_2017_Threads.military.Main.countToSteal;
import static task11_05_12_2017_Threads.military.Main.stolenValuables;
import static task11_05_12_2017_Threads.military.Main.storehouse;
import static task11_05_12_2017_Threads.military.Main.stolen;

public class Ivanov implements Runnable {
    @Override
    public void run() {
        int count = 0;
        while (count < countToSteal && !(storehouse.length<0)) {
            Valuables valuables = storehouse[count];
            count++;
            System.out.println("Иванов украл ("+count+" of "+countToSteal+") : " + valuables);
            synchronized (stolenValuables) {
                stolenValuables[count]=(valuables);
                System.out.println("Готово оружия для отгрузки: " + stolenValuables.length);
                stolenValuables.notify();
                System.out.println("Иванов кричит Петрову, что можно грузить добычу.");
            }

        }
        System.out.println("Укадено " + count + " оружия");
        stolen = true;
    }
}
