package task4_16_11_2017_WeatherStation.interfaces;

public interface Subject {
    public void registerObserver(Observer o);
    public void deleteObserver(Observer o);
    public void notifyObservers();
}
