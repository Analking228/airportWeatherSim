package classes.aircrafts;

import classes.SimException;

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws SimException {

        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        if (type.toLowerCase().equals("helicopter")) {
            return new Helicopter(name, coordinates);
        }
        else if (type.toLowerCase().equals("jetplane")) {
            return new JetPlane(name, coordinates);
        }
        else if (type.toLowerCase().equals("baloon")) {
            return new Baloon(name, coordinates);
        }
        else throw new SimException("ERROR: Type unknown : " + type);
    }
}
