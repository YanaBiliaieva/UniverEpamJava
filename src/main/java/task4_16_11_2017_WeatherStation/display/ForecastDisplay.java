package task4_16_11_2017_WeatherStation.display;

import task4_16_11_2017_WeatherStation.interfaces.DisplayElement;
import task4_16_11_2017_WeatherStation.interfaces.Observer;
import task4_16_11_2017_WeatherStation.interfaces.Subject;

public class ForecastDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private float pressure;
    private Subject weatherData;

    public ForecastDisplay(Subject weatherData){
        if(weatherData==null){
            throw new IllegalArgumentException("WeatherData should not be null");
        }else {
            this.weatherData = weatherData;
            weatherData.registerObserver(this);
        }
    }

    @Override
    public void display() {
        System.out.println("Forecast conditions: "+temperature+" F degrees, humidity "+humidity+" ,pressure "+pressure);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        if(humidity<0||pressure<0) {
            throw new IllegalArgumentException("Cannot update measurements");
        } else {
            this.humidity=humidity;
            this.temperature=temperature;
            this.pressure=pressure;
            display();
        }
    }
}
