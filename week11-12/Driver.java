// Taken from algorithms 4th ed by Sedgewick and Wayne

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;


class Driver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Graph G = new Graph(in);
        int s = Integer.parseInt(args[0]);
        DepthFirstSearch search = new DepthFirstSearch(G, s);
        System.out.print("Vertices connected to " + args[0] + ": ");
        for (int v = 0; v < G.V(); v++) {
            if (search.marked(v))
                System.out.print(v + " ");
        }

        System.out.println();
        if (search.count() != G.V()) 
            System.out.println("NOT connected");
        else
            System.out.println("connected");
    }

}

