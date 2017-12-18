package task11_05_12_2017_Threads.shaoLin;

import static task11_05_12_2017_Threads.shaoLin.Fighting.battleNumber;
import static task11_05_12_2017_Threads.shaoLin.Fighting.fightingList;
import static task11_05_12_2017_Threads.shaoLin.Fighting.moncksEnergyArray;
import static task11_05_12_2017_Threads.shaoLin.Fighting.battleCount;

public class Monk extends Thread{
    private int firstMonck,secondMonck;
    public Monk(int firstMonck, int secondMonck) {
        this.firstMonck=firstMonck;
        this.secondMonck=secondMonck;
    }

    public void run() {
        battleNumber++;
        int result = getWinnerBetweenTwo(firstMonck,secondMonck);
        battleCount++;
        synchronized (fightingList){
            fightingList.add(result);
            fightingList.notify();
        }
    }
    public int getWinnerBetweenTwo(int firstMonck, int secondMonck){
        int winner;
        if(moncksEnergyArray[firstMonck]>moncksEnergyArray[secondMonck]){
            winner = firstMonck;
        }else {
            winner = secondMonck;
        }
        System.out.println("В битве номер "+(battleNumber)+" между монахами номер "+firstMonck+
                " c энергией ци= "+moncksEnergyArray[firstMonck]+"+и "+secondMonck+" c энергией ци ="+moncksEnergyArray[secondMonck]+
                " побеждает монах "+winner + " с энергией ци "+ moncksEnergyArray[winner]);
        return winner;
    }
}
