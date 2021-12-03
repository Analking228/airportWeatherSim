package classes.aircrafts;

import classes.tower.Tower;
import classes.tower.WeatherTower;

public interface    Flyable {
    Tower           WeatherTower = null;

    public void     updateConditions();
    public void     registerTower(WeatherTower weatherTower);
}
