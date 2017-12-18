package task10_01_12_2017_Serialization;
import task3_14_11_2017_Figures.Line;
import task3_14_11_2017_Figures.Point;
import task3_14_11_2017_Figures.Triangle;
import java.io.*;

/**
 * @author Biliaieva Yana
 * @task: для точек линий и треугольник написать сериализацию и десериализацию в файл.
 * записать в файл и прочитать из файла на екран
 */
public class FiguresSerialization {
    static String path="/src/main/resources/points.txt";
    static Point a;
    static Point b;
    static Point c;
    static Line ab;
    static Line ac;
    static Line bc;
    static Triangle abc;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        createFigures();
        serializeFigures();
        unSerializeFigures();
    }
    private static void createFigures() {
        a = new Point(1,1);
        b = new Point(2,2);
        c = new Point(3,3);
        ab = new Line(a,b);
        ac = new Line(a,c);
        bc = new Line(b,c);
        abc = new Triangle(a,b,c);
        System.out.println("Точка А = "+a.toString());
        System.out.println("Точка начала у отрезка АB = "+ab.getBeg().toString());
        System.out.println("Точка начала у отрезка АС =  "+ac.getBeg().toString());
        System.out.println("Вершина A у треугольника ABC = "+abc.getApexA().toString());
        System.out.println("Точка B = "+b.toString());
        System.out.println("Точка конца у отрезка АB = "+ab.getEnd().toString());
        System.out.println("Точка начала у отрезка BC.B = "+bc.getBeg().toString());
        System.out.println("Вершина B у треугольника ABC = "+abc.getApexB().toString());
        System.out.println("Точка C = "+c.toString());
        System.out.println("Точка начала у отрезка  AC = "+ac.getEnd().toString());
        System.out.println("Точка конца у отрезка BC = "+bc.getEnd().toString());
        System.out.println("Вершина C у треугольника ABC = "+abc.getApexC().toString());
    }
    private static void unSerializeFigures() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = null;
        FileInputStream fileInputStream = new FileInputStream(path);
            ois = new ObjectInputStream(fileInputStream);
            a = (Point) ois.readObject();
            b = (Point) ois.readObject();
            c = (Point) ois.readObject();
            ab = (Line) ois.readObject();
            bc = (Line) ois.readObject();
            ac = (Line) ois.readObject();
            abc = (Triangle) ois.readObject();
        System.out.println("Точка А = "+a.toString());
        System.out.println("Точка начала у отрезка АB = "+ab.getBeg().toString());
        System.out.println("Точка начала у отрезка АС =  "+ac.getBeg().toString());
        System.out.println("Вершина A у треугольника ABC = "+abc.getApexA().toString());
        System.out.println("Точка B = "+b.toString());
        System.out.println("Точка конца у отрезка АB = "+ab.getEnd().toString());
        System.out.println("Точка начала у отрезка BC.B = "+bc.getBeg().toString());
        System.out.println("Вершина B у треугольника ABC = "+abc.getApexB().toString());
        System.out.println("Точка C = "+c.toString());
        System.out.println("Точка начала у отрезка  AC = "+ac.getEnd().toString());
        System.out.println("Точка конца у отрезка BC = "+bc.getEnd().toString());
        System.out.println("Вершина C у треугольника ABC = "+abc.getApexC().toString());
    }

    private static void serializeFigures() throws IOException {
        ObjectOutputStream outputStream;
        FileOutputStream fos = new FileOutputStream(path);
        outputStream = new ObjectOutputStream(fos);
        outputStream.writeObject(a);
        outputStream.writeObject(b);
        outputStream.writeObject(c);
        outputStream.writeObject(ab);
        outputStream.writeObject(bc);
        outputStream.writeObject(ac);
        outputStream.writeObject(abc);
        outputStream.flush();
        outputStream.close();
    }

}
