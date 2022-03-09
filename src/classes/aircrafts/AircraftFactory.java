package classes.aircrafts;

import classes.MD5Decoder;
import classes.SimException;

import java.security.NoSuchAlgorithmException;

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws SimException, NoSuchAlgorithmException {

        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        if (type.toLowerCase().equals("helicopter") || MD5Decoder.isMD5code("helicopter", type)) {
            return new Helicopter("helicopter" + '#' + name, coordinates);
        }
        else if (type.toLowerCase().equals("jetplane") || MD5Decoder.isMD5code("jetplane", type)) {
            return new JetPlane("jetplane" + '#' + name, coordinates);
        }
        else if (type.toLowerCase().equals("baloon") || MD5Decoder.isMD5code("baloon", type)) {
            return new Baloon("baloon" + '#' + name, coordinates);
        }
        else throw new SimException("ERROR: Type unknown : \"" + type + "\" or wrong hash provided");
    }
}
