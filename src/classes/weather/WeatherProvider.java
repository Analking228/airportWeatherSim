package classes.weather;

import classes.aircrafts.Coordinates;

public class                        WeatherProvider {
    private static WeatherProvider  WeatherProvider;
    private String                  weather;

    private                         WeatherProvider() {}
    public static WeatherProvider   getProvider() {
        if (WeatherProvider == null)
            WeatherProvider = new WeatherProvider();
        return (WeatherProvider);
    }

    public String                   getCurrentWeather(Coordinates coordinates) {
        //some code
    }
}
