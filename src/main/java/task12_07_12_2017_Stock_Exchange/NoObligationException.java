package task12_07_12_2017_Stock_Exchange;

public class NoObligationException extends Exception {
    public NoObligationException(){
        System.out.println("Не хавтает облигаций, чтобы продолжить торги!");
    }
}
