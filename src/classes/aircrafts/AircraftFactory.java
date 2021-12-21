package classes.aircrafts;

import classes.Exception.SimException;

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws SimException {

        Coordinates coords = new Coordinates(longitude, latitude, height);

        if (type.toLowerCase().equals("helicopter")) {
            return new Helicopter(name, coords);
        }
        else if (type.toLowerCase().equals("jetplane")) {
            return new JetPlane(name, coords);
        }
        else if (type.toLowerCase().equals("baloon")) {
            return new Baloon(name, coords);
        }
        else throw new SimException("ERROR: Type unknown : " + type);
    }
}
