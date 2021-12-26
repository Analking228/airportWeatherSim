package classes;

import classes.aircrafts.Flyable;

import java.util.ArrayList;

abstract public class                   Tower {
    private static ArrayList<Flyable>   observers;

    public Tower() {
        observers = new ArrayList<>();
    }

    public void                         register(Flyable flyable) {
        if (!observers.contains(flyable)) {
            observers.add(flyable);
            System.out.println("Tower says: " + flyable.getNameId() + " registered to weather tower.");
        }
    }

    public void                         unregister(Flyable flyable) {
        if (observers.contains(flyable)) {
            observers.remove(flyable);
            System.out.println("Tower says: " + flyable.getNameId() + " unregistered from weather tower.");
        }
    }

    protected void                      conditionsChanged() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).updateConditions();
        }
    }
}
