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

    // Populate method | Generates n random numbers in [0,1) using a selected generator | Accessibility: public
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

    // Statistics method | Computes n, mean, sample standard deviation, min, and max | Accessibility: public
    public ArrayList<Double> statistics(ArrayList<Double> values) {
        int n = values.size();
        double sum = 0;
        double min = values.get(0);
        double max = values.get(0);

        for (double v : values) {
            sum += v;
            if (v < min) min = v;
            if (v > max) max = v;
        }

        double mean = sum / n;
        double sqDiff = 0;

        for (double v : values)
            sqDiff += (v - mean) * (v - mean);

        double stddev = Math.sqrt(sqDiff / (n - 1));

        ArrayList<Double> r = new ArrayList<>();
        r.add((double) n);
        r.add(mean);
        r.add(stddev);
        r.add(min);
        r.add(max);

        return r;
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