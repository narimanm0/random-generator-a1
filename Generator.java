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

        for (double v: values) {
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

    // Display method | Displays results in tabular form | Accessibility: public
    public void display(ArrayList<Double> r, boolean headerOn) {
        if (headerOn) {
            System.out.printf("%10s %12s %12s %12s %12s%n",
                    "n", "Mean", "StdDev", "Min", "Max");
            System.out.println("-------------------------------------------------------------------------------------");
        }

        System.out.printf("%10.0f %12.6f %12.6f %12.6f %12.6f%n",
                r.get(0), r.get(1), r.get(2), r.get(3), r.get(4));
    }
    
    // Execute method | Executes the generation and display of statistics for different generators and sizes | Accessibility: public
    public void execute() {
        int[] sizes = {100, 1000, 10000};

        System.out.printf("%-22s %10s %12s %12s %12s %12s%n",
                "Generator", "n", "Mean", "StdDev", "Min", "Max");
        System.out.println("-------------------------------------------------------------------------------------");

        boolean header = true;

        for (int n: sizes) {
            for (int g = 0; g < 3; g++) {
                ArrayList<Double> data = populate(n, g);
                ArrayList<Double> stats = statistics(data);

                if (g == 0) System.out.print("java.util.Random     ");
                else if (g == 1) System.out.print("Math.random()        ");
                else System.out.print("ThreadLocalRandom    ");

                display(stats, header);
                header = false;
            }
            System.out.println();
        }

        System.out.println("Total numbers generated: " + totalNumbersGenerated);
    }

    
    // Program entry point.
    public static void main(String[] args) {
        // OBJECT INSTANTIATION
        Generator g = new Generator();
        g.execute();
    }
}