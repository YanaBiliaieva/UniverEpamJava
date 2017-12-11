package task4_16_11_2017_WeatherStationTests;

import task4_16_11_2017_WeatherStation.WeatherData;
import task4_16_11_2017_WeatherStation.display.CurrentConditionDisplay;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WeatherDataTest {
    WeatherData weatherData;
    CurrentConditionDisplay currentConditionDisplay;
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
    @Test
    public void noObservers(){
        weatherData.deleteObserver(currentConditionDisplay);
        System.out.println(weatherData.getObservers().size());
        assertTrue(weatherData.getObservers().size() == 0);

    }
    @Test
    public void isObserverRegistered(){
        weatherData.registerObserver(currentConditionDisplay);
        assertTrue(weatherData.getObservers().size() == 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNegativeHumidity(){
        weatherData.setHumidity(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNegativePressure(){
        weatherData.setPressure(-1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void setWrongMeasurements(){
        weatherData.setMeasurements(-1,-1,-1);
    }

}
