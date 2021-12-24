package classes;

import java.io.*;

public class Logger {

    private static  BufferedWriter writer;

    Logger() {
        try {
            File file = new File("simulation.txt");
            file.delete();
            if (writer == null)
                writer = new BufferedWriter(new FileWriter(file, true));
        } catch (IOException e) {
            System.out.println("ERROR: Simulation file can not be created.");
        }
    }

    public static void addLine(String log) {
        try {
            writer.write(log);
            writer.newLine();
            writer.flush();
        } catch (IOException ioe) {
            System.out.println("ERROR: Simulation file can not be appended");
        }
    }

    public static void closeFile() {
        try {
            if (writer != null)
                writer.close();
        } catch (IOException ioe) {
            System.out.println("ERROR: Simulation file can not be closed");
        }
    }
}