package sample;

import java.util.List;

public class ForecastDataDay {
    private List<Weather> weather;
    private MainValues main;
    private Wind wind;
    private String dt_txt;

    public ForecastDataDay(){

    }

    public ForecastDataDay( List<Weather> press, MainValues main, Wind wind, String dt_txt) {
        this.weather = press;
        this.main = main;
        this.wind = wind;
        this.dt_txt = dt_txt;
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

    public String getDt_txt() {
        return dt_txt;
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

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }

    @Override
    public String toString() {
        return "CurrentData{" +
                "description='" + weather.get(0).description + '\'' +
                ", temp='" + main.temp + '\'' +
                ", windSpeed='" + wind.speed + '\'' +
                ", date='" + dt_txt + '\'' +
                '}';
    }
}
