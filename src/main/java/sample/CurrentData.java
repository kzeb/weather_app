package sample;

import java.util.List;

public class CurrentData {
    private List<Weather> weather;
    private MainValues main;
    private Wind wind;

    public CurrentData(){

    }

    public CurrentData( List<Weather> press, MainValues main, Wind wind) {
        this.weather = press;
        this.main = main;
        this.wind = wind;
    }


    public List<Weather> getWeather() {
        return weather;
    }

    public MainValues getMain() {
        return main;
    }

    public Wind getWind() {
        return wind;
    }


    public void setWeather(List<Weather> press) {
        this.weather = press;
    }

    public void setMain(MainValues main) {
        this.main = main;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    @Override
    public String toString() {
        return "CurrentData{" +
                "description='" + weather.get(0).description + '\'' +
                ", temp='" + main.temp + '\'' +
                ", windSpeed='" + wind.speed + '\'' +
                '}';
    }
}
