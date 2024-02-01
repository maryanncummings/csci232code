// Taken from Algorithms, 4th ed by Sedgewick and Wayne

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class QueueDriver {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(new File("tobe2.txt"));

        ResizingArrayQueue<String> queue = new ResizingArrayQueue<String>();

        while (in.hasNext()) {
            String item = in.next();
            if (!item.equals("-")) {
                queue.enqueue(item);
            }
            else if (!queue.isEmpty()) {
                System.out.print(queue.dequeue() + " ");
            }
        }
        System.out.println("(" + queue.size() + " left on queue)");
    }
} 
