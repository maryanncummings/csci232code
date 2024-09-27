// Taken from algorithms, 4th edition by Sedgewick and Wayne

import java.util.Scanner;

class Driver {

/**********************************************************
 *  
 *  $ more tiny.txt
 *  S E A R C H E X A M P L E
 *
 *  $ java Driver < tiny.txt 
 * S 0
 * E 12
 * X 7
 * A 8
 * R 3
 * C 4
 * H 5
 * M 9
 * L 11
 * P 10
 *
 * A 8
 * C 4
 * E 12
 * H 5
 * L 11
 * M 9
 * P 10
 * R 3
 * S 0
 * X 7
 *********************************************************/

    public static void main(String[] args) {
        BinarySearchTree<String, Integer> st = new BinarySearchTree<String, Integer>();
        
        // StopWatch timer = new StopWatch();
        Scanner in = new Scanner(System.in);
        int i = 0;
        while (in.hasNext()) {
            String key = in.next();
            st.put(key, i);
            i++;
        }
       
        System.out.println("Printing keys/values in the order stored");
        for (String s: st.keys()) {
            System.out.println(s + " " + st.get(s));
        }

        // Print InOrder traversal
        System.out.println("Inorder traversal");
        for (String s: st.OrderedTraversal("In")) {
            System.out.println(s + " " + st.get(s));
        }

        // Print PreOrder traveral
         System.out.println("Preorder traversal");
        for (String s: st.OrderedTraversal("Pre")) {
            System.out.println(s + " " + st.get(s));
        }

        // Print PostOrder travers
        System.out.println("Postorder traversal");
        for (String s: st.OrderedTraversal("Post")) {
            System.out.println(s + " " + st.get(s));
        }
      
        System.out.println("height is " + st.height());
        System.out.println("min is " + st.min());
        System.out.println("max is " + st.max());
        System.out.println("rank of E is " + st.rank("E"));
        System.out.println("rank of A is " + st.rank("A"));
        System.out.println("rank of R is " + st.rank("R"));
        System.out.println("rank of X is " + st.rank("X"));
        System.out.println("rank of J is " + st.rank("J"));
        System.out.println("size is " + st.size());
    }
}

