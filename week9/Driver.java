// Taken from algorithms, 4th edition by Sedgewick and Wayne

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Driver {


    public static void main(String[] args) throws FileNotFoundException {
        LinearProbingHashST<String, Integer> st = new LinearProbingHashST<String, Integer>(16);
        
        // StopWatch timer = new StopWatch();
        Scanner in = new Scanner(System.in);
        int i = 0;
        while (in.hasNext()) {
            String key = in.next();
            st.put(key, i);
            i++;
        }
        
        System.out.println("Size of linear probing symbol table " + st.size());
        for (String s: st.keys()) {
            System.out.printf("%-12s %-10d %-20d %d\n", s, st.get(s),
                s.hashCode(), st.hash(s));
        }
    }
}

