package sample;

import com.google.gson.Gson;
import javafx.scene.control.Alert;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ConnectionInitializer {
    private CurrentData c_readout;
    private ForecastData f_readout;

    public ConnectionInitializer() {
    }

    public CurrentData c_connect(String city, String country){
        try {
            RestTemplate restTemplate = new RestTemplate();
            String fooResourceUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "," + country + "&units=metric&appid=0cfc82d6eca370e26b474c674857d3fa";
            ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
            String body = response.getBody();
            this.c_readout = new Gson().fromJson(body, CurrentData.class);
        }catch (RuntimeException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No connection");
            alert.setContentText("No connection with API !!!");
            alert.showAndWait();
            c_connect(city, country);
        }
        return c_readout;
    }

    public ForecastData f_connect(String city, String country){
        try {
            RestTemplate restTemplate = new RestTemplate();
            String fooResourceUrl = "https://api.openweathermap.org/data/2.5/forecast?q=" + city + "," + country + "&units=metric&appid=0cfc82d6eca370e26b474c674857d3fa";
            ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
            String body = response.getBody();
            this.f_readout = new Gson().fromJson(body, ForecastData.class);
        }catch (RuntimeException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No connection");
            alert.setContentText("No connection with API !!!");
            alert.showAndWait();
            c_connect(city, country);
        }
        return f_readout;
    }
}
