
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;
import java.io.File;
import java.io.FileNotFoundException;

public class LDiff {
    
    private static void Closest(double[] a, int n) {
        double num1_diff, num2_diff, diff, least_diff;
        if (n < 2) 
               throw new IllegalArgumentException("array too small");
       
        num1_diff = a[0];
        num2_diff = a[1];
        least_diff = Math.abs(a[1] - a[0]);
        for (int i = 2; i < n; ++i) {
            if ((diff = Math.abs(a[i] - a[i-1])) < least_diff) {
                num1_diff = a[i-1];
                num2_diff = a[i];
                least_diff = diff; 
            }
        }
        System.out.println("The numbers " + num1_diff + " and " +
            num2_diff + " are the closest pair with a difference of "
            + String.format("%.6f", least_diff));
        return;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException  { 
        
        Scanner in = new Scanner(new File("lab2in.txt"));
        
        double arr[] = new double[8000];
       
        int i = 0; 
        while (in.hasNextDouble()) {
            arr[i++] = in.nextDouble();
        }

        in.close();
        //Start determining Big O here
        // sort - O(nlg n)
        Arrays.sort(arr, 0, i);
 
        // O(n)
        Closest(arr, i);

        // Total is O(n log n))
    } 
    
}
