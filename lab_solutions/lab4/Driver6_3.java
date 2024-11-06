// Taken from algorithms, 4th edition by Sedgewick and Wayne

import java.util.Scanner;

class Driver6_3 {

    public static void main(String[] args) {
        RedBlackTree<String, Integer> rbt = new RedBlackTree<String, Integer>();
        
        Scanner in = new Scanner(System.in);
        int i = 0;
        while (in.hasNext()) {
            String key = in.next();
            rbt.put(key, i++);
        }

        // Print InOrder traversal
        for (String s: rbt.keys()) {
            System.out.println(s + "\t" + rbt.get(s) + "\t" + rbt.getColor(s));
        }
        System.out.println();
    }
}

