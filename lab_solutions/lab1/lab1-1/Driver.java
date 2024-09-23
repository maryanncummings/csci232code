import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Driver {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner input1 = new Scanner(new File("dnums.txt"));

        LinkedList<Double> dbl_ll = new LinkedList<Double>();

        while(input1.hasNextDouble()) {
           dbl_ll.insert(input1.nextDouble());
        }
        
        dbl_ll.printListDataType();
        System.out.println();

        while (!dbl_ll.isEmpty()) {
            System.out.print("List is ");
            dbl_ll.GoToHead();
            while (!dbl_ll.atEndOfList()) {
                System.out.print(dbl_ll.getCurData() + " ");
                if (dbl_ll.nextData() == false) {
                    break;
                }
            }
            System.out.println();
            dbl_ll.GoToHead();
            dbl_ll.delete(dbl_ll.getCurData());
        }

        System.out.println();

        Scanner input2 = new Scanner(new File("strings.txt"));

        LinkedList<String> str_ll = new LinkedList<String>();

        while(input2.hasNext()) {
           str_ll.insert(input2.next());
        }

        str_ll.printListDataType();
        System.out.println();

        while (!str_ll.isEmpty()) {
            System.out.print("List is ");
            str_ll.GoToHead();
            while (!str_ll.atEndOfList()) {
                System.out.print(str_ll.getCurData() + " ");
                if (str_ll.nextData() == false) {
                    break;
                }
            }
            System.out.println();
            str_ll.GoToHead();
            str_ll.delete(str_ll.getCurData());
        }
    }
}
