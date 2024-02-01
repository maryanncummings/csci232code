// Taken from Algorithms 4th ed by Sedgewick and Wayne

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ReverseStrings {

    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner in = new Scanner(new File("tinyTale.txt"));

        StackOfStrings stack = new StackOfStrings();
        
        int i = 0;
        while(in.hasNext()){
           stack.push(in.next());
        }
        
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
    
}
