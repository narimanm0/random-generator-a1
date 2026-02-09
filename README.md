# Random Generator A1
## Overview
This project implements a Java program that generates random numbers using three different built-in random number generators and analyzes the generated data using descriptive statistics.

The goal is to observe how statistical properties of a uniform distribution on the interval **[0, 1)** behave as the sample size increases, and to compare the behavior across different random number generation approaches.



## Random Number Generators Used
The program evaluates the following Java random number generators:

1. **java.util.Random**
2. **Math.random()**
3. **java.util.concurrent.ThreadLocalRandom**

Each generator produces `double` values in the range **[0, 1)**.



## Program Structure

The program is implemented in a single class named `Generator` and includes the following methods:

### `populate(int n, int randNumGen)`
- Generates `n` random double values in [0,1) using a selected generator.
- Returns an `ArrayList<Double>` containing the generated values.

### `statistics(ArrayList<Double> values)`
- Computes:
  - Sample size (`n`)
  - Mean
  - Sample standard deviation
  - Minimum value
  - Maximum value
- Returns results in the order: `[n, mean, stddev, min, max]`

### `display(ArrayList<Double> results, boolean headerOn)`
- Prints statistical results in a formatted table.
- Optionally includes a header row.

### `execute()`
- Runs the full workflow for multiple sample sizes (100, 1,000, 10,000) and all three generators.
- Calls `populate`, `statistics`, and `display`.
- Produces 9 rows of output.

### `main(String[] args)`
- Creates a `Generator` object and calls `execute()`.




## Sample Output

```
Generator                       n         Mean       StdDev          Min          Max
-------------------------------------------------------------------------------------
java.util.Random              100     0.461805     0.275873     0.006933     0.998504
Math.random()                 100     0.525263     0.305802     0.014195     0.997087
ThreadLocalRandom             100     0.510716     0.279932     0.007876     0.988415

java.util.Random             1000     0.511013     0.285991     0.001012     0.998870
Math.random()                1000     0.500853     0.292714     0.000802     0.999114
ThreadLocalRandom            1000     0.512206     0.293223     0.001473     0.999951

java.util.Random            10000     0.490676     0.289191     0.000043     0.999945
Math.random()               10000     0.500905     0.287831     0.000118     0.999836
ThreadLocalRandom           10000     0.501219     0.287770     0.000024     0.999878

Total numbers generated: 33300
```



## Observations
- **Mean** approaches 0.5 as sample size increases.
- **Standard deviation** approaches ~0.2887, the theoretical value for a uniform [0,1) distribution.
- **Minimum values** approach 0, and **maximum values** approach 1.
- Small deviations occur for smaller sample sizes due to random variability.



## Usage
#### Compile
```
javac Generator.java
```
#### Run
```
java Generator
```
