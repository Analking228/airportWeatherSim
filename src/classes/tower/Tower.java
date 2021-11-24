package classes.tower;

import classes.aircrafts.Flyable;

import java.util.ArrayList;

abstract public class                   Tower {
    private static ArrayList<Flyable>   observers;

    public Tower() {
        observers = new ArrayList<>();
    }

    abstract public void                register(Flyable flyable);

    abstract public void                unregister(Flyable flyable);

    protected void                      conditionsChanged() {
        //some code
    }
}
