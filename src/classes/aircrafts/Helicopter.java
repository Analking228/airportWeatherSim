package classes.aircrafts;

import classes.Logger;
import classes.WeatherTower;
import java.util.HashMap;

public class            Helicopter extends Aircraft implements Flyable{
    WeatherTower        weatherTower;
    HashMap<String, String> reports;

    protected Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
        reports = new HashMap<>();
        reports.put("SNOW", "snow");
        reports.put("SUN", "sun");
        reports.put("RAIN", "rain");
        reports.put("FOG", "Ебаный в рот с вами вертолет!");
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
                        this.coordinates.getHeight() - 12);
                break;
        }
        Logger.addLine(this.getNameId() + ": " + reports.get(weather));

        if (this.coordinates.getHeight() <= 0) {
            Logger.addLine(this.getNameId() + ": Landing ["
                    + this.coordinates.getLongitude()
                    + ','
                    + this.coordinates.getLatitude()
                    + "]");
            this.weatherTower.unregister(this);
        }
    }
}
