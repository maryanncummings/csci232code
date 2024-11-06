// Taken from algorithms, 4th edition by Sedgewick and Wayne

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Driver {

    public static void main(String[] args) throws FileNotFoundException {
        RedBlackTree<String, VarValue> rbt = new RedBlackTree<String, VarValue>();
        String temp; 
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            // System.out.println("just read " + str);
            if (str.equals("float") || str.equals("int")) {
                // str is the data type so this is a declaration statement
                temp = in.next();
                String varName = temp.substring(0, temp.length() -1);
                VarValue varType = new VarValue(varName, str);
                rbt.put(varName, varType);
            }
            else {
                // System.out.print("in else " + str);
                // str is the variable name
                VarValue vv = rbt.get(str);
                in.next(); // throw away the =
                temp = in.next();
                String value = temp.substring(0, temp.length() - 1);
                vv.SetValue(value);
                rbt.put(str, vv);
            }
                 
        }
        
        for (String s: rbt.keys()) {
            System.out.println(String.format("%-15s %-10s %-5s", s, rbt.get(s), rbt.getColor(s)));
        }

    }
}

