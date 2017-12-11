package task4_16_11_2017_WeatherStation;

import task4_16_11_2017_WeatherStation.display.CurrentConditionDisplay;
import task4_16_11_2017_WeatherStation.display.ForecastDisplay;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.json.JSONException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WeatherController implements Initializable {
    @FXML
    public Label temperatureLabel;
    @FXML
    public  Label humidityLabel;
    @FXML
    public  Label pressureLabel;
    @FXML
    public  Button getButton;
    @FXML
    public  Label forecastPressureLabel;
    @FXML
    public  Label forecastTemperatureLabel;
    @FXML
    public  Label forecastHumidityLabel;
    private CurrentConditionDisplay currentConditionDisplay;
    private ForecastDisplay forecastDisplay;
    private WeatherData currentWeatherData;
    private WeatherData forecastWeatherData;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        currentWeatherData=new WeatherData();
        forecastWeatherData=new WeatherData();
        currentConditionDisplay=new CurrentConditionDisplay(currentWeatherData);
        forecastDisplay=new ForecastDisplay(forecastWeatherData);
    }
    public void getWeatherData() throws IOException, JSONException {
        ConnectionAdapter connectionAdapter=new ConnectionAdapter();//получаем
        //рассылаем
        currentWeatherData.setMeasurements(connectionAdapter.getCurrentTemperature(),connectionAdapter.getCurrentHumidity(),connectionAdapter.getCurrentPressure());
        forecastWeatherData.setMeasurements(connectionAdapter.getForecastTemperature(),connectionAdapter.getForecastHumidity(),connectionAdapter.getForecastPressure());
        setLabels();
    }

    private void setLabels(){
        temperatureLabel.setText(String.valueOf(currentWeatherData.getTemperature()));
        humidityLabel.setText(String.valueOf(currentWeatherData.getHumidity()));
        pressureLabel.setText(String.valueOf(currentWeatherData.getPressure()));
        forecastTemperatureLabel.setText(String.valueOf(forecastWeatherData.getTemperature()));
        forecastHumidityLabel.setText(String.valueOf(forecastWeatherData.getHumidity()));
        forecastPressureLabel.setText(String.valueOf(forecastWeatherData.getPressure()));
    }
}
