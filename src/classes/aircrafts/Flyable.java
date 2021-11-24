package classes.aircrafts;

import classes.tower.Tower;

public interface    Flyable {
    Tower           tower = null;

    public void     updateConditions();
    public void     registerTower();
}
