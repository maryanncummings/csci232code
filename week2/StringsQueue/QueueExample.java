// Taken from Algorithms, 4th ed by Sedgewick and Wayne

/******************************************************************************
 *  
 *  % more tobe2.txt 
 *  to be or not to - be - - that - - - is
 * 
 *  % java QueueExample < tobe2.txt 
 *  to be or not to be 
 *  Left in queue: that is 
 *
 ******************************************************************************/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class QueueExample {
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner in = new Scanner(new File("tobe2.txt"));
        
        String item;
        
        QueueOfStrings queue = new QueueOfStrings();
        
        while(in.hasNext()){
           item = in.next();
        
            if (!item.equals("-")) {
                queue.enqueue(item); 
            }
            else if (queue.isEmpty()) {
                System.out.println("BAD INPUT"); 
            }
            else {
                System.out.print(queue.dequeue() + " ");
            }
        }

        // print what's left in the queue 
        System.out.print("\nLeft on queue: ");
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println();
    } 
} 
