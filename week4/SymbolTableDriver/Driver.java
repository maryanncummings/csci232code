
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// java Driver < tinyTale.txt

class Driver {
    
    public static void main(String[] args) throws FileNotFoundException {
        int i = 0;
        
        Scanner sc = new Scanner(new File("in.txt"));
        
        SymbolTable st = new SymbolTable();
        
        while (sc.hasNext()) {
            String key = sc.next();
            st.put(key,i);
            i++;
        }
        
        for (String s:st.keys()) {
            System.out.println(s + " " + st.get(s));
        }  
        System.out.println("Number of words read is " + i);
        System.out.println("Size of table is " + st.size());
    }
}

