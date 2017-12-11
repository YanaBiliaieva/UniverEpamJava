package task4_16_11_2017_WeatherStationTests;

import task4_16_11_2017_WeatherStation.WeatherData;
import task4_16_11_2017_WeatherStation.display.CurrentConditionDisplay;
import task4_16_11_2017_WeatherStation.display.ForecastDisplay;
import task4_16_11_2017_WeatherStation.interfaces.Subject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CurrentConditionsDisplayTest {
    CurrentConditionDisplay currentConditionDisplay;
    Subject weatherData;
    @Before
    public void init() {
        weatherData=new WeatherData();
        currentConditionDisplay=new CurrentConditionDisplay(weatherData);
    }
    @After
    public void tearDown() {
        weatherData=null;
        currentConditionDisplay=null;
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateWrongMeasurements(){
        currentConditionDisplay.update(-1,-1,-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void displayWithNullParameters(){
        weatherData=null;
        currentConditionDisplay=new CurrentConditionDisplay(weatherData);
    }
}
