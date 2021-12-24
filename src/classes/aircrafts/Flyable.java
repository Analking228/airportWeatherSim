package classes.aircrafts;

import classes.WeatherTower;

public interface    Flyable {

    public void     updateConditions();
    public void     registerTower(WeatherTower weatherTower);
    String          getNameId();
}
