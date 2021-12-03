package classes.aircrafts;

import classes.tower.WeatherTower;

public class            Helicopter extends Aircraft implements Flyable{
    WeatherTower        weatherTower;

    protected Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }

    @Override
    public void updateConditions() {
        weatherTower.getWeather(this.coordinates);
    }
}
