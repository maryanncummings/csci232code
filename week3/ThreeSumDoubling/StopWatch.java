// taken from Algorithms, 4th ed by Sedgewick and Wayne
// part of the library of helpful functions 

public class StopWatch {

    private final long start;

    /**
     * Initializes a new stopwatch.
     */
    public StopWatch() {
        start = System.currentTimeMillis();
    } 


    /**
     * Returns the elapsed wall time (in seconds) since the stopwatch was created.
     *
     * @return elapsed CPU time (in seconds) since the stopwatch was created
     */
    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
    
}
