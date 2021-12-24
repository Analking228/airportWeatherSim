package classes;

import classes.SimException;
import classes.Logger;

import java.io.IOException;

public class Program {
    public static void main (String[]args) {

        Logger  logger = new Logger();
        Parser  parser = new Parser();

        try {

            if (args.length != 1) {
                throw new SimException("ERROR: Provide a file path as a single argument.");
            }


            parser.parseScenario(args[0]);

            Simulation simulation = new Simulation(logger, parser.getFlyables(), parser.getSimCount());
            if (simulation.getFlyableSize() == 0)
                throw new SimException("ERROR: No aircrafts in the scenario file.");

            simulation.runSimulation(simulation);

            System.out.println("We have run " + simulation.tower.getTotalSims() + " simulations.");
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
