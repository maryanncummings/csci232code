// Taken from algorithms 4th ed by Sedgewick and Wayne

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;


class Driver {


    public static void main(String[] args) throws FileNotFoundException {
  
        Scanner in = new Scanner(System.in);

        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        PrimMST mst = new PrimMST(G);
        for (Edge e : mst.edges()) {
            System.out.println(e);
        }
        System.out.printf("%.5f\n", mst.weight());

    }
}

