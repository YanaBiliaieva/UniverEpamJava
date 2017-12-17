package task8_24_11_2017_StackCalculator;

public class CannotParseException extends Exception {
    public CannotParseException(){
        System.out.println("Not enough digitals to parse");
    }
}
