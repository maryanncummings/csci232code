// lab1-2
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException; 

class Driver_lab1_2 {


    public static void main(String[] args) throws FileNotFoundException {
  
        Scanner in = new Scanner(new File("hamlet.txt"));

        Stack<String> stk = new Stack<String>();

        String item;

        while (in.hasNext()) {

            item = in.next();

            if (!item.equals("$")) {
                stk.push(item);
            }
            else if (stk.isEmpty()) {
                System.out.println("BAD INPUT");
            }
            else {
                System.out.print(stk.pop() + " ");
            }
        }

        // print what's left on the stack
        System.out.print("\nLeft on stack: ");
        while (!stk.isEmpty()) {
            System.out.print(stk.pop() + " ");
        }
        System.out.println();
    }
}

