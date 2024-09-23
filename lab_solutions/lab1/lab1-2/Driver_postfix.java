// lab1-2
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
 
class Driver_postfix {


    public static void main(String[] args) throws FileNotFoundException {
  
        Scanner in = new Scanner(new File("equation.txt"));

        Stack<Integer> stk = new Stack<Integer>();

        String inp;

        while (in.hasNext()) {

            inp = in.next();

            if (!inp.equals("*") && !inp.equals("+")) {
                System.out.println("pushing " + inp);
                stk.push(Integer.parseInt(inp));
            }
            else if (stk.isEmpty()) {
                System.out.println("BAD INPUT");
            }
            else {
                int num1 = stk.pop();
                System.out.println("popped " + num1);
                int num2 = stk.pop();
                System.out.println("popped " + num2);
                if (inp.equals("*")) {
                    System.out.println(inp + "-pushing " + (num1 * num2));
                    stk.push(num1 * num2);
                }
                else {
                    // we know it must be + if it is not * for this 
                    // simple assignment
                    System.out.println(inp + "-pushing " + (num1 + num2));
                    stk.push(num1 + num2);
                }
            }
        }

        // print the answer 
        System.out.print("The result of the postfix equation is ");
        System.out.print(stk.pop());
        System.out.println();
    }
}

