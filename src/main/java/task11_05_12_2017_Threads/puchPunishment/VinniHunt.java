package task11_05_12_2017_Threads.puchPunishment;

public class VinniHunt {
    private boolean isFounded;
    private int numberOfParts;
    public static Forest forest;
    public static VinniHunt vinniHunt;
    public static void main(String[] args) throws InterruptedException{
        forest=new Forest(100,25);
        releaseBees();

        System.out.println();
        if (vinniHunt.isFounded){
            System.out.println("Медведь найден");
        }
        else System.out.println("Медведь не найден");
    }
    public static void releaseBees(){
        vinniHunt = new VinniHunt();
        AngryBee firstBee = new AngryBee(vinniHunt);
        Thread thread1 = new Thread(firstBee);
        System.out.println("Начинается поиск...");
        thread1.run();

    }
    public synchronized void giveForestPart(AngryBee angryBee) {
            angryBee.setForestSectorNumber(numberOfParts);
            angryBee.setSector(new boolean[]{forest.getForest()[numberOfParts++]});

    }

    public void setTheBearIsFound() {
        this.isFounded = true;

    }
    public boolean founded() {
        return isFounded;
    }
}