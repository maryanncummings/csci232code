// Taken from algorithms, 4th ed by Sedgewick and Wayne

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ThreeSumFast {
    
    private static boolean containsDuplicates(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i-1]) {
                System.out.println("duplicate is " + a[i] + " at " + i);
                return true;
            }
        }
        return false;
    }
    
    public static int count(int[] a) {
        int n = a.length;
        Arrays.sort(a);
        //if (containsDuplicates(a)) throw new IllegalArgumentException("array contains duplicate integers");
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int k = Arrays.binarySearch(a, -(a[i] + a[j]));
                if (k > j) count++;
            }
        }
        return count;
    } 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException  { 
        
        File file = new File(args[0]);
        
        Scanner scanner = new Scanner(file);
        
        int max = Integer.parseInt(args[1]);
        int [] a = new int[max];
        int i = 0;
        
        while (scanner.hasNextInt()) {
            a[i++] = scanner.nextInt();
        }

        StopWatchCPU timer = new StopWatchCPU();
        int count = count(a);
        System.out.println("elapsed time = " + timer.elapsedTime());
        System.out.println(count);
    } 
    
}
