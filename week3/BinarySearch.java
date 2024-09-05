// Taken from Algorithms, 4th ed by Sedgewick and Wayne
// To run: java BinarySearch TinyW.txt < TinyIn.txt

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;  // needed for calling the sort method
import java.util.Scanner;

public class BinarySearch {   

    /**
     * This class should not be instantiated.
     */
    private BinarySearch() { }

    /**
     * Returns the index of the specified key in the specified array.
     */
    public static int indexOf(int[] a, int key, int size) {
        int lo = 0;  //index into array
        int hi = size - 1;  // index into array
        
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            }
            else if (key > a[mid]) {
                lo = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }

    private static void show(int[] a, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    
    /**
     * Reads in a sequence of integers from the whitelist file, specified as
     * a file as a command-line argument; reads another set of integers also from
     * a file as a command line argument.  It then
     * prints to standard output those integers that do <em>not</em> appear in the first file.
     *
     */
    public static void main(String[] args) throws FileNotFoundException {
    

        // read the integers from a file
        File file = new File(args[0]);
        
        Scanner inpFile = new Scanner(file);
        
        int [] whitelist = new int [100];
        int i = 0;
        while(inpFile.hasNextInt()){
           whitelist[i++] = inpFile.nextInt();
        }
        System.out.println("Before sort");
        show(whitelist, i);

        // sort the array - O(n log n)
        Arrays.sort(whitelist, 0, i);
        System.out.println("After sort");
        show(whitelist, i);

        Scanner in = new Scanner(System.in);

        // read integer key from standard input; print if not in whitelist
        System.out.print("Enter number to search for in list: ");
        int key = in.nextInt();
        if (BinarySearch.indexOf(whitelist, key, i) == -1) {
            System.out.println("Did Not Find " + key);
        }
        else {
            System.out.println("Found " + key + " in list");
        }
    }
}

