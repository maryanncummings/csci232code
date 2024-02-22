// Taken from Algorithms, 4th ed by Sedgewick and Wayne
// To run: java Towers - then input the number of rings

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;  // needed for calling the sort method
import java.util.Scanner;

public class Towers {   


    public static void showTowerMoves(int n, String from, String to,
                               String spare) {

        if (n == 1) {
            System.out.println("move from " + from + " to " + to);
        }
        else {
            System.out.println("dealing with " + n + " rings");
            showTowerMoves(n-1, from, spare, to);
            showTowerMoves(1, from, to, spare);
            showTowerMoves(n-1, spare, to, from);
        }
    }
    
    public static void main(String[] args) {
    
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of rings: ");
        int num = in.nextInt();

        showTowerMoves(num, "f", "t", "s");
    }
}

