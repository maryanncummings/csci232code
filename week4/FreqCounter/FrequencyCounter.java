//Taken from algorithms, 4th edition by Sedgewick and Wayne
/******************************************************************************
 *  Compilation:  javac FrequencyCounter.java
 *  Execution:    java FrequencyCounter L 
 *
 *  Read in a list of words from   file and print out
 *  the most frequently occurring word that has length greater than
 *  a given threshold.
 *
 *
 *  $ java FrequencyCounter 8
 * business 122
 * distinct = 5126
 * words    = 14346

 * $ java FrequencyCounter 1
 * it 10
 * distinct = 20
 * words    = 60
 *
 ******************************************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FrequencyCounter {

    public static void main(String[] args) throws FileNotFoundException {
        int distinct = 0, words = 0;
        int minlen = Integer.parseInt(args[0]);
        SymbolTable st = new SymbolTable();

        // compute frequency counts
        
        Scanner in = new Scanner(new File("Tale.txt"));
        
        while (in.hasNext()) {
            String key = in.next();
        
            if (key.length() < minlen) continue;
            words++;
            if (st.contains(key)) {
                st.put(key, st.get(key) + 1);
            }
            else {
                st.put(key, 1);
                distinct++;
            }
        }

        // find a key with the highest frequency count
        String max = "";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max))
                max = word;
        }

        System.out.println(max + " " + st.get(max));
        System.out.println("distinct = " + distinct);
        System.out.println("words    = " + words);
    }
    
}
