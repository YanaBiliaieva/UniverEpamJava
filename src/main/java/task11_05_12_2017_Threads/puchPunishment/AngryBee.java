package task11_05_12_2017_Threads.puchPunishment;

public class AngryBee implements Runnable{
    public int beeId;
    private VinniHunt vinniHunt;
    private boolean[] sector;
    private int forestSectorNumber;

    public AngryBee(VinniHunt vinniHunt) {
        beeId = beeId++;
        this.vinniHunt = vinniHunt;
    }
    @Override
    public void run() {
        while (!vinniHunt.founded()){
            vinniHunt.giveForestPart(this);
            if (sector == null) break;
            System.out.println("Пчела номер " + beeId + " ищет в части леса номер " + forestSectorNumber);
            for (boolean b : sector){
                if (b) {
                    vinniHunt.setTheBearIsFound();
                    System.out.println("Медведь найден в секторе " + forestSectorNumber);
                    break;
                }
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Пчела номер " + beeId + " улетела с части леса номер " + forestSectorNumber);
        }
    }
    public void setSector(boolean[] sector) {
        this.sector = sector;
    }
    public void setForestSectorNumber(int forestSectorNumber) {
        this.forestSectorNumber = forestSectorNumber;
    }
}