// Taken from Algorithms, 4th ed - Sedgewick and Wayne
// part of the library of helpful functions

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class StopWatchCPU {

/**
 *  The {@code StopwatchCPU} data type is for measuring
 *  the CPU time used during a programming task.
 *
 *  See {@link Stopwatch} for a version that measures wall-clock time
 *  (the real time that elapses).
 *
 *  @author Josh Hug
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */

    private static final double NANOSECONDS_PER_SECOND = 1000000000;

    private final ThreadMXBean threadTimer;
    private final long start;
            
    /**
     * Initializes a new stopwatch.
     */
    public StopWatchCPU() {  
        threadTimer = ManagementFactory.getThreadMXBean();
        start = threadTimer.getCurrentThreadCpuTime();
    }   
        
    /**
     * Returns the elapsed CPU time (in seconds) since the stopwatch was created.
     *
     * @return elapsed CPU time (in seconds) since the stopwatch was created
     */
    public double elapsedTime() {
        long now = threadTimer.getCurrentThreadCpuTime();
        return (now - start) / NANOSECONDS_PER_SECOND;
    }

}
