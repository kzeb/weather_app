package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.joda.time.DateTime;

public class Controller {
    @FXML
    private TextField curr_city;
    @FXML
    private TextField curr_country;

    @FXML
    private Label curr_desc;
    @FXML
    private Label curr_temp;
    @FXML
    private Label curr_press;
    @FXML
    private Label curr_hum;
    @FXML
    private Label curr_wind;
    @FXML
    private ImageView curr_image;



    @FXML
    private TextField fore_city;
    @FXML
    private TextField fore_country;

    @FXML
    private Label fore_date1;
    @FXML
    private Label fore_desc1;
    @FXML
    private Label fore_temp1;
    @FXML
    private Label fore_press1;
    @FXML
    private Label fore_hum1;
    @FXML
    private Label fore_wind1;
    @FXML
    private ImageView fore_image1;

    @FXML
    private Label fore_date2;
    @FXML
    private Label fore_desc2;
    @FXML
    private Label fore_temp2;
    @FXML
    private Label fore_press2;
    @FXML
    private Label fore_hum2;
    @FXML
    private Label fore_wind2;
    @FXML
    private ImageView fore_image2;

    @FXML
    private Label fore_date3;
    @FXML
    private Label fore_desc3;
    @FXML
    private Label fore_temp3;
    @FXML
    private Label fore_press3;
    @FXML
    private Label fore_hum3;
    @FXML
    private Label fore_wind3;
    @FXML
    private ImageView fore_image3;

    @FXML
    private Label fore_date4;
    @FXML
    private Label fore_desc4;
    @FXML
    private Label fore_temp4;
    @FXML
    private Label fore_press4;
    @FXML
    private Label fore_hum4;
    @FXML
    private Label fore_wind4;
    @FXML
    private ImageView fore_image4;

    @FXML
    private Label fore_date5;
    @FXML
    private Label fore_desc5;
    @FXML
    private Label fore_temp5;
    @FXML
    private Label fore_press5;
    @FXML
    private Label fore_hum5;
    @FXML
    private Label fore_wind5;
    @FXML
    private ImageView fore_image5;


    @FXML
    private void curr_getWeather(){
        String city = curr_city.getText();
        String country = curr_country.getText();

        while(validateInput(city, country)) {
            ConnectionInitializer con = new ConnectionInitializer();
            CurrentData readout = con.c_connect(city, country);

            c_display(readout);
            break;
        }
    }

    @FXML
    private void fore_getWeather(){
        String city = fore_city.getText();
        String country = fore_country.getText();

        while(validateInput(city, country)) {
            ConnectionInitializer con = new ConnectionInitializer();
            ForecastData readout = con.f_connect(city, country);
            if(readout == null){
                break;
            }

            int choice = getRightTimeData();

            f_display(choice, readout, fore_date1, fore_desc1, fore_temp1, fore_press1, fore_hum1, fore_wind1, fore_image1);
            f_display(choice += 8, readout, fore_date2, fore_desc2, fore_temp2, fore_press2, fore_hum2, fore_wind2, fore_image2);
            f_display(choice += 8, readout, fore_date3, fore_desc3, fore_temp3, fore_press3, fore_hum3, fore_wind3, fore_image3);
            f_display(choice += 8, readout, fore_date4, fore_desc4, fore_temp4, fore_press4, fore_hum4, fore_wind4, fore_image4);
            f_display(choice += 8, readout, fore_date5, fore_desc5, fore_temp5, fore_press5, fore_hum5, fore_wind5, fore_image5);
            break;
        }
    }

    private boolean validateInput(String city, String country){
        try{
            if(city.equals("") || country.equals("")){
                throw (new IllegalArgumentException());
            }
        } catch(IllegalArgumentException e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("No argument detected");
            alert.setContentText("You haven't passed either city name or the name of country");
            alert.showAndWait();
            return false;
        }
        return true;
    }

    private int getRightTimeData(){
        DateTime dt = new DateTime();
        int hours = dt.getHourOfDay();
        int choice = 0;

        if(0 <= hours && hours < 3){ choice = 4; }
        else if(3 <= hours && hours < 6){ choice = 3; }
        else if(6 <= hours && hours < 9){ choice = 2; }
        else if(9 <= hours && hours < 12){ choice = 1; }
        else if(12 <= hours && hours < 15){ choice = 0; }
        else if(15 <= hours && hours < 18){ choice = 7; }
        else if(18 <= hours && hours < 21){ choice = 6; }
        else if(21 <= hours && hours < 24){ choice = 5; }

        return choice;
    }

    private void c_display(CurrentData readout){
        curr_desc.setText(readout.getWeather().get(0).description);
        curr_temp.setText((readout.getMain().temp) + " \u00b0C");
        curr_press.setText(Double.toString(readout.getMain().pressure) + " hPa");
        curr_hum.setText(Double.toString(readout.getMain().humidity) + " %");
        curr_wind.setText(Double.toString(readout.getWind().speed) + " meters per second    " + Double.toString(readout.getWind().deg) + " deg");
        Image image = new Image("http://openweathermap.org/img/w/" + readout.getWeather().get(0).icon + ".png");
        curr_image.setImage(image);
    }

    private void f_display(int choice, ForecastData readout, Label date, Label desc, Label temp, Label press, Label hum, Label wind, ImageView image) {
        date.setText(readout.getDays().get(choice).getDt_txt().substring(0, 10));
        desc.setText(readout.getDays().get(choice).getWeather().get(0).description);
        temp.setText(Double.toString(readout.getDays().get(choice).getMain().temp) + " \u00b0C");
        press.setText(Double.toString(readout.getDays().get(choice).getMain().pressure) + " hPa");
        hum.setText(Double.toString(readout.getDays().get(choice).getMain().humidity) + " %");
        wind.setText(Double.toString(readout.getDays().get(choice).getWind().speed) + " m/s, " + Double.toString(readout.getDays().get(choice).getWind().deg) + " deg");
        Image image1 = new Image("http://openweathermap.org/img/w/" + readout.getDays().get(choice).getWeather().get(0).icon + ".png");
        image.setImage(image1);
    }
}


