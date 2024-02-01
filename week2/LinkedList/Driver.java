import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Driver {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(new File("in.txt"));

        LinkedList<String> ll = new LinkedList<String>();

        int i = 0;
        while(in.hasNext()){
           ll.insert(in.next());
        }
        System.out.print("List is ");
        while (ll.getCurData() != null) {
            System.out.print(ll.getCurData() + " ");
            if (ll.nextData() == false) {
                break;
            }
            
        } 
    }
}
