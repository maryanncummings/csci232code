// Driver to find a maximum double in a list using a generic data structure 
import java.util.Scanner;

class FindDMaxDriver {
    public static void main(String args[]) {

        // now we have a generic class so we have to move
        // some tasks back to main - max, and checking for 
        // number being positive
        MyList<Double> posnumlist = new MyList<Double>(50);
        double num;  // temporary holder

        Scanner in = new Scanner(new File("dnums.txt"));
        while (in.hasNextDouble()) {
            num = in.nextDouble(); 
            if (num >= 0) {
                posnumlist.Add(num);
            }
        }
    
        posnumlist.Delete(15.4);

        System.out.println("Is 3.2 in the list? " + posnumlist.Search(3.2));
        System.out.println("Is 3.4 in the list? " + posnumlist.Search(3.4));

        double max = 0;
        for (int i = 0; i < posnumlist.Size(); i++) {
            num = posnumlist.getElement(i);
            if (num > max) {
                max = num;
            } 
            System.out.println(posnumlist.getElement(i)); 
        }
        System.out.println("The maximum number is " + max);
    }
}
