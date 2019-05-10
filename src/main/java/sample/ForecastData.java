package sample;

import java.util.List;

public class ForecastData {
    private List<ForecastDataDay> list;

    public ForecastData(){

    }

    public ForecastData( List<ForecastDataDay> list) {
        this.list = list;
    }

    public List<ForecastDataDay> getDays() {
        return list;
    }

    public void setDays(List<ForecastDataDay> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Forecast Data{" +
                "descripton='" + list.get(35).getWeather().get(0).description + '\'' +
                ", temperature='" + list.get(35).getMain().temp + '\'' +
                ", windSpeed='" + list.get(35).getWind().speed + '\'' +
                ", date='" + list.get(35).getDt_txt() + '\'' +
                '}';
    }
}
