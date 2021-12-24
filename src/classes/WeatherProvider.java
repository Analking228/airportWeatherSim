package classes;

import classes.aircrafts.Coordinates;

import java.util.Random;

public class                        WeatherProvider {
    private static WeatherProvider  WeatherProvider;
    static private final String[]   weather = {"SUN", "RAIN", "SNOW", "FOG"};

    private                         WeatherProvider() {}
    public static WeatherProvider   getProvider() {
        if (WeatherProvider == null)
            WeatherProvider = new WeatherProvider();
        return (WeatherProvider);
    }

    public String                   getCurrentWeather(Coordinates coordinates) {
        int seed = (coordinates.getLongitude() + coordinates.getLatitude()) / coordinates.getHeight();
        seed += new Random().nextInt(100);

        return (weather[seed % 4]);
    }
}
