
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Driver {
    
    public static void main(String[] args) throws FileNotFoundException {
        int i = 0;
        
        Scanner in = new Scanner(new File("lab3in.txt"));
        
        SymbolTable<Integer, Integer> st = 
                  new SymbolTable<Integer, Integer>();
        
        int key, value;
        while (in.hasNextInt()) {
            key = in.nextInt();
            value = in.nextInt();
            st.put(key,value);
            i++;
        }

        if (st.contains(5)) {
            System.out.println("5 was found in the symbol table with value " + 
                        + st.get(5));
            st.delete(5);
        }
        
        for (int num:st.keys()) {
            System.out.println(num + "\t" + st.get(num));
        }  
        System.out.println("Minimum key with value is " + 
                           st.min() + ", " + st.get(st.min()));
        System.out.println("Maximum key with value is " + 
                           st.max() +  ", " + st.get(st.max()));  

    }
}

