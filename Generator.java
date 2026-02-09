/*
    Name: Nariman Mammadov
    Project: Random Generator 
    Class: CSCI-3612 - 20964
    Date: 09.02.2026
*/

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

// CLASS DEFINITION
public class Generator { 

    // CLASS ATTRIBUTE
    private int totalNumbersGenerated = 0;

    // METHOD DEFINITION

    public ArrayList<Double> populate(int n, int randNumGen) {
        ArrayList<Double> values = new ArrayList<>();

        if (randNumGen == 0) {
            Random r = new Random();
            for (int i = 0; i < n; i++)
                values.add(r.nextDouble());
        } else if (randNumGen == 1) {
            for (int i = 0; i < n; i++)
                values.add(Math.random());
        } else {
            // Thread-safe random doubles.
            for (int i = 0; i < n; i++)
                values.add(ThreadLocalRandom.current().nextDouble());
        }

        totalNumbersGenerated += n;
        return values;
    }
    
    public void execute() {

    }

    
    // Program entry point.
    public static void main(String[] args) {
        // OBJECT INSTANTIATION
        Generator g = new Generator();
        g.execute();
    }
}