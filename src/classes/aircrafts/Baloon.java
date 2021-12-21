package classes.aircrafts;

import classes.Logger.Logger;
import classes.tower.WeatherTower;
import com.oracle.tools.packager.Log;

import java.util.HashMap;

public class                Baloon extends Aircraft implements Flyable{
    WeatherTower            weatherTower;
    HashMap<String, String> reports;

    protected Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
        reports = new HashMap<>();
        reports.put("SNOW", "Where banana?");
        reports.put("RAIN", "Chupapi-Munyanya!");
        reports.put("FOG", "I am under the water.");
        reports.put("SUN", "Please help me.");
    }

    @Override
    public void             registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }

    @Override
    public void             updateConditions() {

        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude() + 2,
                        this.coordinates.getHeight() + 4);
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

        if (this.coordinates.getHeight() <= 0){
            Logger.addLine(this.getNameId() + ": Landing ["
                    + this.coordinates.getLongitude()
                    + ','
                    + this.coordinates.getLatitude()
                    + "]");
            this.weatherTower.unregister(this);
        }
    }
}
