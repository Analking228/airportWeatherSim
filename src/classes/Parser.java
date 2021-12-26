package classes;

import classes.aircrafts.AircraftFactory;
import classes.aircrafts.Flyable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {

    private int                 SimCount;
    private ArrayList<Flyable>  flyable = new ArrayList<>();

    public void                 parseScenario(String filePath) throws SimException, IOException {

        BufferedReader          reader = new BufferedReader(new FileReader(filePath));
        String                  ln;
        int                     lnCount = 1;

        ln = reader.readLine();
        if (ln == null)
            throw new SimException("ERROR: Empty simulation file.");
        if (ln.length() > 0) {
            try {
                SimCount = Integer.parseInt(ln.trim());
                if (SimCount <= 0)
                    throw new SimException("");
            } catch (NumberFormatException e) {
                throw new SimException("ERROR: Wrong simulations count"
                        + " or line provided");
            }
        }

        String[]                split;

        while (ln != null) {
            ln = reader.readLine();
            lnCount++;
            if (ln == null || ln.length() == 0)
                continue;
            split = ln.split(" ");
            if (split.length == 0)
                continue;
            if (split.length != 5)
                throw new SimException("ERROR: Invalid line #" + lnCount
                        + " in a scenario file.");
            try {
                int[]           coords = { Integer.parseInt(split[2]),
                        Integer.parseInt(split[3]), Integer.parseInt(split[4]) };
                for (int c : coords) {
                    if (c < 1)
                        throw new SimException("ERROR: Invalid line #" + lnCount
                                + " in a scenario file." +
                                "\nCoordinates must be POSITIVE INTEGERS!");
                }
                flyable.add(AircraftFactory.newAircraft(split[0], split[1], coords[0],
                        coords[1], coords[2]));
            } catch (NumberFormatException e) {
                throw new SimException("ERROR: Invalid line #" + lnCount + " in a scenario file." +
                        "\nCoordinates must be 3 positive, space-separated integers.");
            }
        }
        reader.close();
    }

    int                         getSimCount() { return SimCount; }
    ArrayList<Flyable>          getFlyables() { return flyable; }
}
