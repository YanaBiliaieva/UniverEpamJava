package task4_16_11_2017_WeatherStation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        WeatherController controller=new WeatherController();
        //запускаем окно
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("app/weather.fxml"));
        loader.setController(controller);
        Parent root = (Parent) loader.load();
        primaryStage.setTitle("Weather");
        primaryStage.setScene(new Scene(root, 500, 275));
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
