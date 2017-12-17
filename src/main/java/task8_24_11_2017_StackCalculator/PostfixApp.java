package task8_24_11_2017_StackCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Biliaieva Yana
 * Task: стаковый калькулятор
 * добавить sin cos
 * ввод: 345+*612+/-
 */
public class PostfixApp {
    public static void main(String[] args) throws IOException, CannotParseException {
        String input;
        double result;
        while (true) {
            System.out.print("Compute: ");
            input = getInput();// Ввод строки с клавиатуры
            if (input.equals("")) break;// Завершение, если нажата клавиша[Enter]
            result = computeExpression(input);//Обработка выражения
            System.out.println("Result="+ result);
        }
    }

    public static double computeExpression(String expression) throws CannotParseException{
        ParseInfixToPostfix converter = new ParseInfixToPostfix(expression);
        String output = converter.doTransform().trim();
        ParsePost parser = new ParsePost(output);// Создание объекта  для разбора выражения
        return parser.doParse();
    }

    public static String getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        String input = br.readLine();
        return input;
    }
}
