package classes;

import classes.aircrafts.Flyable;

import java.util.ArrayList;

public class Simulation {

    private Logger              logger;
    private WeatherTower        tower;
    private int                 simCount;
    private ArrayList<Flyable>  flyable = new ArrayList<>();

    public                  Simulation(Logger logger, ArrayList<Flyable>  flyable, int simCount) {
        this.logger = logger;
        this.flyable = flyable;
        this.simCount = simCount;
    }

    void runSimulation(Simulation simulation) {

        for (Flyable a : simulation.flyable) {
            a.registerTower(simulation.tower);
        }

        while (simulation.tower.getSimsCount() < simulation.tower.getTotalSims()) {
            Logger.addLine("\t== Simulation #" + (simulation.tower.getSimsCount() + 1) + " ==");
            simulation.tower.changeWeather();
            simulation.tower.countSimulation();
        }
    }

    int     getFlyableSize() { return flyable.size(); }
}
