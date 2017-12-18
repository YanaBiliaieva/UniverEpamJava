package task11_05_12_2017_Threads.shaoLin;

import java.util.LinkedList;

public class Fighting {
    public final int numberOfMonks = 20;
    public static int[] moncksEnergyArray;
    public static LinkedList<Integer> fightingList = new LinkedList<>();
    public static volatile int battleCount = 0;
    public static volatile int battleNumber = 0;

    public Fighting() {
        randomMonksCreation();
        fightingList.add(0);
        fightingList.notify();
        fightingList.add(numberOfMonks -1);
        fightingList.notify();
    }

    public void start(){
        while (battleCount < numberOfMonks -2){
            int firstMonck;
            int secondMonck;
            synchronized (fightingList){
                while (battleCount < numberOfMonks -1 && fightingList.size()<2){
                    try {
                        fightingList.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Cannot start waining/");
                    }
                }
                firstMonck = fightingList.poll();
                secondMonck = fightingList.poll();
            }
           Monk monk=new Monk(firstMonck,secondMonck);
            monk.start();
        }
    }

    public void randomMonksCreation(){
        System.out.println("Создаем "+ numberOfMonks +" монахов");
        moncksEnergyArray = new int[numberOfMonks];
        for (int i = 0; i< numberOfMonks; i++){
            int energy = (int)(Math.random()* 200);//даем рандомно енергию ци
            moncksEnergyArray[i] = energy;
        }
    }

}