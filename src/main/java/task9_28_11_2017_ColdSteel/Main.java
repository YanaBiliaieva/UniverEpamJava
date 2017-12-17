package task9_28_11_2017_ColdSteel;

import org.apache.log4j.Logger;
import task9_28_11_2017_ColdSteel.domParser.KnifesDomParser;
import task9_28_11_2017_ColdSteel.entities.Knife;
import task9_28_11_2017_ColdSteel.saxParser.KnifesSaxParser;
import task9_28_11_2017_ColdSteel.staxParser.KnifesStaxParser;
import task9_28_11_2017_ColdSteel.validator.KnivesXmlValidator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**@author Yana Biliaieva
 * @task Создать файл XML и соответствующую ему схему XSD.
 * При разработке XSD использовать простые и комплексные типы, перечисления, шаблоны и предельные значения, обязательно использование атрибутов и типа ID.
 * Сгенерировать (создать) Java-класс, соответствующий данному описанию.
 *
 * Создать Java-приложение для разбора XML-документа и инициализации коллекции объектов информацией из XML-файла. Для разбора использовать SAX, DOM и StAX парсеры. Для сортировки объектов использовать интерфейс Comparator.
 * Произвести проверку XML-документа с привлечением XSD.
 * Определить метод, производящий преобразование разработанного XML-документа в документ, указанный в каждом задании.
 * Вариант 7. Холодное оружие. Холодное оружие можно структурировать по следующей схеме:
 * Type – тип (нож, кинжал, сабля и т.д.).
 * Handy – одно или двуручное.
 * Origin – страна производства.
 * Visual (должно быть несколько) – визуальные характеристики: клинок (длина клинка [10 – n см], ширина клинка [10 – n мм]), материал (клинок [сталь, чугун, медь и т.д.]), рукоять (деревянная [если да, то указать тип дерева], пластик, металл), наличие кровостока (есть либо нет).
 * Value – коллекционный либо нет. Корневой элемент назвать Knife.
 * Добавить свои Exceptions, логирование в файл уровни INFO и ERROR
 */

public class Main {
    public static String xmlFile = "src/main/java/task9_28_11_2017_ColdSteel/xml/xmlFile.xml";
    public static String xsdFile = "src/main/java/task9_28_11_2017_ColdSteel/xml/xsdFile.xsd";
    static Logger log = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {

        KnivesXmlValidator validator=new KnivesXmlValidator();//
        String validationResult=validator.validate(xsdFile, xmlFile);
        System.out.println("Validation result:"+validationResult);
        System.out.println("DOM parsing:");
        List<Knife> knifesDom = new KnifesDomParser().parseDocument(xmlFile);
        sortKnifesByName(knifesDom);
        log.debug("Knifes objects from DOM parser:" + Arrays.deepToString(knifesDom.toArray()));
        printKnifes(knifesDom);

        System.out.println("Running SAX parsing:");
        List<Knife> knifesSax = new KnifesSaxParser().parseDocument(xmlFile);
        sortKnifesByName(knifesSax);
        log.debug("Knifes objects from SAX parser:" + Arrays.deepToString(knifesSax.toArray()));
        printKnifes(knifesSax);

        System.out.println("--------------Running STAX parsing:");
        List<Knife> knifesStax = new KnifesStaxParser().parseDocument(xmlFile);
        sortKnifesByName(knifesStax);
        log.debug("Knifes objects from STAX parser:" + Arrays.deepToString(knifesStax.toArray()));
        printKnifes(knifesStax);

    }
    private static void sortKnifesByName(List<Knife> knifes) {
        Collections.sort(knifes, Comparator.comparing(Knife::getName));
    }
    private static void printKnifes(List<Knife> knifes) {
        for (Knife knife : knifes) {
            System.out.println("Name: " + knife.getName());
            System.out.println("Type: " + knife.getKnifeType());
            System.out.println("Handy: " + knife.getKnifeHandy());
            System.out.println("Origin: " + knife.getKnifeOrigin());
            System.out.println("Blade: " + knife.getKnifeVisual().getKnifeBlade().getLength() + " " + knife.getKnifeVisual().getKnifeBlade().getWidth() + " " + knife.getKnifeVisual().getKnifeBlade().getMetal());
            System.out.println("Collection: " + knife.isCollection());
            System.out.println("");
        }
    }
}
