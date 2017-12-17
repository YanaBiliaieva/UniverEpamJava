package task8_24_11_2017_StackCalculator;

public class ParsePost {
    private StackX theStack;
    private String input;
    //--------------------------------------------------------------
    public ParsePost(String s){ input = s; }
    //--------------------------------------------------------------

    public double doParse() throws CannotParseException {
        theStack = new StackX(20); // Создание объекта стека
        String ch;
        int j;
        double num1, num2, intermediateResult;
        if(input.length() < 3){
            throw new CannotParseException();
        }else {
            for (j = 0; j < input.length(); j++) {// Для каждого символа
                int k = j + 1;
                while (k < input.length()) {
                    if (input.charAt(k) != ' ') k++;
                    else break;
                }
                ch = input.substring(j, k);
                j = k;
                theStack.displayStack("" + ch + " ");// *диагностика*
                if (ch.charAt(0) >= '0' && ch.charAt(0) <= '9') {// Если это цифра
                    theStack.push((ch));// Занести в стек
                } else {// Если это оператор
                    num2 = Double.parseDouble(theStack.pop());// Извлечение операндов
                    switch (ch) {// Выполнение арифметической
                        case "+":// операции
                            String pop = theStack.pop();
                            if (pop == null) pop = "0";
                            num1 = Double.parseDouble(pop);
                            intermediateResult = num1 + num2;
                            break;
                        case "-":
                            pop = theStack.pop();
                            if (pop == null) pop = "0";
                            num1 = Double.parseDouble(pop);
                            intermediateResult = num1 - num2;
                            break;
                        case "*":
                            pop = theStack.pop();
                            if (pop == null) pop = "1";
                            num1 = Double.parseDouble(pop);
                            intermediateResult = num1 * num2;
                            break;
                        case "/":
                            pop = theStack.pop();
                            if (pop == null) pop = "1";
                            num1 = Double.parseDouble(pop);
                            intermediateResult = num1 / num2;
                            break;
                        case "cos":
                            intermediateResult = Math.cos(num2);
                            break;
                        case "sin":
                            intermediateResult = Math.sin(num2);
                            break;
                        default:
                            intermediateResult = 0;
                    }
                    theStack.push(intermediateResult + "");// Занесение промежуточного результата в стек
                }
            }
        }

        if (!theStack.isEmpty()) {
            intermediateResult = Double.parseDouble(theStack.pop());// Получение результата
        } else {
            intermediateResult = 0;
        }

        return intermediateResult;
    }


}
