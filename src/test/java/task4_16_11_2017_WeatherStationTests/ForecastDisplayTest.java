package task4_16_11_2017_WeatherStationTests;

import task4_16_11_2017_WeatherStation.WeatherData;
import task4_16_11_2017_WeatherStation.display.ForecastDisplay;
import task4_16_11_2017_WeatherStation.interfaces.Subject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ForecastDisplayTest {
    ForecastDisplay forecastDisplay;
    Subject weatherData;
    @Before
    public void init() {
        weatherData=new WeatherData();
        forecastDisplay=new ForecastDisplay(weatherData);
    }
    @After
    public void tearDown() {
        weatherData=null;
        forecastDisplay=null;
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateWrongMeasurements(){
     forecastDisplay.update(-1,-1,-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void forecastDisplayWithNullParameters(){
        weatherData=null;
        forecastDisplay=new ForecastDisplay(weatherData);
    }
}
