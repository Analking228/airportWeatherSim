package classes.tower;

import classes.aircrafts.Coordinates;
import classes.weather.WeatherProvider;

public class WeatherTower extends Tower {

    public String       getWeather(Coordinates coordinates) {
        return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
    }

    void        changeWeather() {
        this.conditionsChanged();
    }
}
