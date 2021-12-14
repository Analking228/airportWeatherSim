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
        this.weatherTower.register(this);
    }

    @Override
    public void updateConditions() {

        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude() + 10,
                        this.coordinates.getHeight() + 2);
                break;
            case "RAIN":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude() + 5,
                        this.coordinates.getHeight());
                break;
            case "FOG":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude() + 1,
                        this.coordinates.getHeight());
                break;
            case "SNOW":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() - 7);
                break;
        }
    }
}
