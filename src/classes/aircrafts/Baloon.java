package classes.aircrafts;

import classes.tower.WeatherTower;

public class            Baloon extends Aircraft implements Flyable{
    WeatherTower        weatherTower;

    protected Baloon(String name, Coordinates coordinates) {
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
