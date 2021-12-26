package classes;

import classes.aircrafts.Flyable;

import java.io.IOException;
import java.util.ArrayList;

public class Simulator {

    private final WeatherTower  tower = new WeatherTower();
    private final Logger        logger = new Logger();
    private int                 simCount;
    private final int           simTotal;
    private ArrayList<Flyable>  flyable = new ArrayList<>();

    public                      Simulator(ArrayList<Flyable>  flyable, int simTotal) {
        this.flyable = flyable;
        this.simTotal = simTotal;
        this.simCount = 0;
    }

    void                        runSimulator(Simulator simulator) {

        for (Flyable a : simulator.flyable) {
            a.registerTower(simulator.tower);
        }

        while (simulator.simCount < simulator.simTotal) {
            Logger.addLine("\t\t*** Simulation #" + (simulator.simCount + 1) + " ***");
            simulator.tower.changeWeather();
            simulator.simCount++;
        }
    }

    public static void          main (String[]args) {

        try {

            if (args.length != 1) {
                throw new SimException("ERROR: Provide single argument - simulation file name.");
            }

            Parser              parser = new Parser();
            parser.parseScenario(args[0]);

            Simulator simulator = new Simulator(parser.getFlyables(), parser.getSimCount());
            if (simulator.flyable.size() == 0)
                throw new SimException("ERROR: No aircrafts in scenario file.");

            simulator.runSimulator(simulator);

            System.out.println("We have run " + simulator.simTotal + " simulations.");
            System.out.println("Results are logged to simulation.txt file.");

        } catch (SimException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR: I can't find or read the file \'" + args[0] + "\', darling.");
        } finally {
            Logger.closeFile();
        }
    }
}
