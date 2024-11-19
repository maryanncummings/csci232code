// Taken from algorithms 4th ed by Sedgewick and Wayne

/******************************************************************************
 *  Execution:    java Driver  <  input.txt
 *
 *  % java Driver < tinyEWG.txt
 *  
 *  0-7 0.16000
 *  2-3 0.17000
 *  1-7 0.19000
 *  0-2 0.26000
 *  5-7 0.28000
 *  4-5 0.35000
 *  6-2 0.40000
 *  1.81000
 *
 ******************************************************************************/


import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;


class Driver {


    public static void main(String[] args) throws FileNotFoundException {
  
        Scanner in = new Scanner(System.in);

        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        KruskalMST mst = new KruskalMST(G);
        for (Edge e : mst.edges()) {
            System.out.println(e);
        }
        System.out.printf("%.5f\n", mst.weight());

    }
}

