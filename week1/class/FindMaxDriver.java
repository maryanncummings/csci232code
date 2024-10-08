// Example - program to find max number in a list of positive numbers 
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class FindMaxDriver {
    public static void main(String args[]) throws FileNotFoundException {

        PositiveNumsList pnl = new PositiveNumsList(50);

        Scanner in = new Scanner(new File("nums.txt"));
        while (in.hasNextInt()) {
            
            pnl.Add(in.nextInt());
        }
    
        System.out.println("The maximum number is " + pnl.Max());
        pnl.Delete(pnl.Max());
        System.out.println("The maximum number is " + pnl.Max());

        System.out.println("Is 10 in the list? " + pnl.Search(10));
    }
}
