package task11_05_12_2017_Threads.puch;

/**
 * Тема: многопоточность.
 а)Первая задача о Винни-Пухе, или неправильные пчелы. Неправильные пчелы, подсчитав в конце месяца убытки от наличия в лесу Винни-Пуха,
 решили разыскать его и наказать в назидание всем другим любителям сладкого. Для поисков медведя они поделили лес на участки,
 каждый из которых прочесывает одна стая неправильных пчел. В случае нахождения медведя на своем участке стая проводит показательное наказание и возвращается в улей.
 Если участок прочесан, а Винни-Пух на нем не обнаружен, стая также возвращается в улей.
 Требуется создать многопоточное приложение, моделирующее действия пчел. При решении использовать парадигму портфеля задач.
 *  Задача является независимой единицей
 работы. Задачи помещаются в портфель, разделяемый несколькими рабочими
 процессами. Каждый рабочий процесс получает задачу из портфеля, выполняет ее,
 возможно порождая новые задачи в портфеле. Обработка заканчивается, когда
 портфель пуст.
 */
 public class PuhPunishment implements Runnable {
    public static int i=0;
    private static boolean[]  forest;

    public static boolean[] getForest() {
        return new boolean[100];
    }

    public static void setForest(boolean[] forest) {
        PuhPunishment.forest = forest;
    }

    public static boolean bearIsFound;
    public static void main(String[] args) {
        forest=getForest();
        forest[10]=true;
        PuhPunishment puhPunishment =new PuhPunishment();
        Thread bee1=new Thread(puhPunishment);
        Thread bee2=new Thread(puhPunishment);
        Thread bee3=new Thread(puhPunishment);
        bee1.start();
        bee2.start();
        bee3.start();
    }
    public synchronized boolean forestPartGiver(){
        boolean b;
        i++;
        b=forest[i];
        System.out.println(" b=forest["+i+"]--"+b);
        return b;
    }

    @Override
    public void run() {
        while (!bearIsFound==true){
            boolean c=forestPartGiver();
            if(c==true){
                bearIsFound=true;
                System.out.println("The bear was found");
                break;
            }
        }
    }
}
