package classes.tower;

import classes.aircrafts.Flyable;

import java.util.ArrayList;

abstract public class                   Tower {
    private static ArrayList<Flyable>   observers;

    public Tower() {
        observers = new ArrayList<>();
    }

    public void                register(Flyable flyable) {
        observers.add(flyable);
        System.out.println("Tower says: registered to weather tower.");
    }

    public void                unregister(Flyable flyable) {
        observers.remove(flyable);
        System.out.println("Tower says: unregistered from weather tower.");
    }

    protected void                      conditionsChanged() {
        //some code
    }
}
