package task4_16_11_2017_WeatherStation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ConnectionAdapter {
    private final String currentWeatherURl ="http://api.openweathermap.org/data/2.5/weather?q=London&APPID=f0ebdc9bc073767d2b97c75668cfd8cf&units=metric";
    private final String forecastWeatherURl ="http://api.openweathermap.org/data/2.5/forecast?q=London&APPID=f0ebdc9bc073767d2b97c75668cfd8cf&units=metric";
    private float currentTemperature;
    private float currentPressure;
    private float currentHumidity;
    private float forecastTemperature;
    private float forecastPressure;
    private float forecastHumidity;
    public ConnectionAdapter() throws IOException, JSONException {
        receiveCurrentData();
        receiveForecastData();
    }
    public void receiveCurrentData() throws IOException, JSONException {
        URL address = new URL(currentWeatherURl);
        HttpURLConnection connection = (HttpURLConnection) address.openConnection();
        connection.connect();
        System.out.println("currentWeatherURl="+ currentWeatherURl);
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = in.read()) != -1) {
            sb.append((char) cp);
        }
        String inputLine=sb.toString();
        JSONObject json = new JSONObject(inputLine);
        JSONObject main = json.getJSONObject("main");
        currentTemperature = (float) main.getDouble("temp");
        currentPressure = main.getLong("pressure");
        currentHumidity = main.getLong("humidity");
        System.out.println("Current temperature=="+currentTemperature);
        System.out.println("Current pressure=="+currentPressure);
        System.out.println("Current humidity=="+currentHumidity);


    }
    public void receiveForecastData() throws IOException, JSONException{
        URL address = new URL(forecastWeatherURl);
        HttpURLConnection connection = (HttpURLConnection) address.openConnection();
        connection.connect();
        System.out.println("forecastWeatherURl="+ forecastWeatherURl);
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = in.read()) != -1) {
            sb.append((char) cp);
        }
        String inputLine=sb.toString();
        JSONObject json = new JSONObject(inputLine);
        JSONArray list = json.getJSONArray("list");
        JSONObject main = list.getJSONObject(0).getJSONObject("main");
        forecastTemperature = (float) main.getDouble("temp");
        forecastPressure = main.getLong("pressure");
        forecastHumidity = main.getLong("humidity");
        System.out.println("Forecast temperature=="+forecastTemperature);
        System.out.println("Forecast pressure=="+forecastPressure);
        System.out.println("Forecast humidity=="+forecastHumidity);
    }


    public float getCurrentTemperature() {
        return currentTemperature;
    }

    public float getCurrentPressure() {
        return currentPressure;
    }

    public float getCurrentHumidity() {
        return currentHumidity;
    }

    public float getForecastTemperature() {
        return forecastTemperature;
    }

    public float getForecastPressure() {
        return forecastPressure;
    }

    public float getForecastHumidity() {
        return forecastHumidity;
    }
}
