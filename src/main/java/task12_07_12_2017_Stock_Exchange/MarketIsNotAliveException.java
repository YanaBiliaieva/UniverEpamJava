package task12_07_12_2017_Stock_Exchange;

public class MarketIsNotAliveException extends Exception {
    public MarketIsNotAliveException(){
        System.out.println("Рынок упал");
    }
}
