package task11_05_12_2017_Threads.military;

/**
 * @author Biliaieva Yana
 * @task Первая военная задача. Темной-темной ночью прапорщики Иванов, Петров и Нечепорчук занимаются хищением военного имущества со склада родной военной части.
 * Будучи умными людьми и отличниками боевой и строевой подготовки, прапорщики ввели разделение труда:
 * Иванов выносит имущество со склада, Петров грузит его в грузовик, а Нечепорчук подсчитывает рыночную стоимость добычи.
 * Требуется составить многопоточное приложение, моделирующее деятельность прапорщиков.
 * При решении использовать парадигму «производитель-потребитель» с активным ожиданием.
 */
public class Main {
    public static final int countToSteal = 30;
    public static int price;
    public static boolean stolen;
    public static boolean loaded;
    public static boolean counted;
    public static Valuables[] storehouse ;
    public static  Valuables[] stolenValuables;
    public static  Valuables[] loadedValuables;
    public static  Valuables[] countedValuables;
    public static int totalPrice;

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            Valuables valuables = Valuables.create();
            storehouse[i]= valuables;
        }
        Petrov petrov = new Petrov();
        petrov.run();
        Ivanov ivanov = new Ivanov();
        ivanov.run();
        Nechiporchuk nechiporchuk = new Nechiporchuk();
        nechiporchuk.run();
    }

}
