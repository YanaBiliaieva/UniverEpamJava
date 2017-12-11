package task4_16_11_2017_WeatherStation;

import task4_16_11_2017_WeatherStation.interfaces.Observer;
import task4_16_11_2017_WeatherStation.interfaces.Subject;

import java.util.ArrayList;

public class WeatherData implements Subject {
    private ArrayList observers;
    private float temperature;
    private float pressure;
    private float humidity;

    public WeatherData(){
        observers=new ArrayList();
    }

    @Override
    public void registerObserver(Observer o) {
    observers.add(o);
    }

    @Override
    public void deleteObserver(Observer o) {
    int i=observers.indexOf(o);
        if(i>=0){
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer=(Observer)observers.get(i);
            observer.update(temperature,humidity,pressure);
        }
    }

    public void measurementsChanged(){
        notifyObservers();
    }
    public void setMeasurements(float temperature,float humidity,float pressure){
        if(humidity<0||pressure<0) {
            throw new IllegalArgumentException("Cannot set measurements");
        } else {
            this.temperature=temperature;
            this.humidity=humidity;
            this.pressure=pressure;
            measurementsChanged();
        }
    }

    public float getTemperature() {
        return temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }


    public void setPressure(float pressure) {
        if(pressure<0) {
            throw new IllegalArgumentException("Pressure must be more then 0.");
        } else this.pressure = pressure;
    }

    public void setHumidity(float humidity) {
        if(humidity<0) {
            throw new IllegalArgumentException("Humidity must be more then 0.");
        } else this.humidity = humidity;
    }

    public ArrayList getObservers() {
        return observers;
    }


    @Override
    public String toString() {
        return "WeatherData{" +
                "observers=" +observers +
                ", temperature=" + temperature +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                '}';
    }
}
