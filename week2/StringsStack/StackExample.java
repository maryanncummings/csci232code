// Taken from Algorithms, 4th ed by Sedgewick and Wayne

/******************************************************************************
 *  
 *  % more tobe.txt 
 *  to be or not to - be - -
 * 
 *  % java StackExample < tobe.txt 
 *  to be not 
 *  Left of stack: to be or
 *
 ******************************************************************************/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class StackExample {
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner in = new Scanner(new File("tobe.txt"));
        
        String item;
        
        StackOfStrings stack = new StackOfStrings();
        
        while(in.hasNext()){
           item = in.next();
        
            if (!item.equals("-")) {
                stack.push(item); 
            }
            else if (stack.isEmpty()) {
                System.out.println("BAD INPUT"); 
            }
            else {
                System.out.print(stack.pop() + " ");
            }
        }

        // print what's left on the stack
        System.out.print("\nLeft on stack: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    } 
} 
