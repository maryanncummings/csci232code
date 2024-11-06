import java.util.Scanner;
import java.io.*;
import java.nio.file.*;

/*
 * Data class needed:
 * CovidPlace - include continent, location string, date, total_cases, 
 * new cases, population
 *
 * data structures:
 * min priority queue for top 3 locations
 * BST<Integer, Covid>
 */

public class Program1 {

    public static void main(String args[]) throws Exception {

        MinPQ<CovidPlace> pq = new MinPQ<CovidPlace>(3);
        BinarySearchTree<Long, CovidPlace> bst = new BinarySearchTree();        
        String compStr = new String("");

        boolean firstTimeThru = true; // have to deal with the first line of data

        BufferedReader br = 
            new BufferedReader(new FileReader("owid-covid-data.csv"));  

        // get rid of first line
        String line = br.readLine();
        while ((line = br.readLine()) != null) { 
            String[] lineData = line.split(",");

            CovidPlace cp = new CovidPlace(lineData);
        
            if (firstTimeThru) {
                // System.out.println("FIRST TIME: Country: " + cp.Location() + " " + cp.NewCases());
                pq.insert(cp);
                compStr = cp.Location();
                firstTimeThru = false;
            }
            else if (compStr.equals(cp.Location())) {
                
                pq.insert(cp); 

                // remove minimum if 4 entries on the PQ
                if (pq.size() > 3) { 
                    pq.delMin();
                }   // top 3 entries are on the PQ
            }
            else { // we found a new country
        
                // place the entries in the PQ into the BST
                while (!pq.isEmpty()) {
                    CovidPlace mincp = pq.delMin();
                    // System.out.println("Country: " + mincp.Location() +
                    //                    " New Cases: " + mincp.NewCases());
                    bst.put(mincp.NewCases(), mincp);
                }
                pq.insert(cp);
                compStr = cp.Location();
            }
        }
        br.close();
        // put the last country into BST
        while (!pq.isEmpty()) {
            CovidPlace mincp = pq.delMin();
            bst.put(mincp.NewCases(), mincp);
        }
   

        // Print InOrder traversal to console
        /*
        System.out.println("Inorder traversal");
        for (Long k: bst.OrderedTraversal("In")) {
            CovidPlace cp = bst.get(k);
            System.out.println("New cases: " + cp.NewCases() + " at " + cp.Location() + "/" + cp.Continent() + 
                " on " + cp.Date() +
                " Total: " + cp.TotalCases() +
                " Pop: " + cp.Population());
        }
*/

        // Print InOrder traversal
        FileWriter myWriter = new FileWriter("out1.txt");
        for (Long k: bst.OrderedTraversal("In")) {
            CovidPlace cp = bst.get(k);
            myWriter.write("New cases: " + cp.NewCases() + " at " + cp.Location() + "/" + cp.Continent() +
                " on " + cp.Date() +
                " Total: " + cp.TotalCases() +
                " Pop: " + cp.Population() + "\n");
        }
        myWriter.close();

        // Print InOrder traversal
        /*
        Path file = Path.of("out2.txt");
        for (Long k: bst.OrderedTraversal("In")) {
            CovidPlace cp = bst.get(k);
            Files.writeString(file,"New cases: " + cp.NewCases() + " at " + cp.Location() + "/" + cp.Continent() +
                " on " + cp.Date() +
                " Total: " + cp.TotalCases() +
                " Pop: " + cp.Population() + "\n", StandardOpenOption.APPEND);
        }

        // Print InOrder traversal
        BufferedWriter writer = new BufferedWriter(new FileWriter("out3.txt", true));
        writer.flush();
        for (Long k: bst.OrderedTraversal("In")) {
            CovidPlace cp = bst.get(k);
            writer.write("New cases: " + cp.NewCases() + " at " + cp.Location() + "/" + cp.Continent() +
                " on " + cp.Date() +
                " Total: " + cp.TotalCases() +
                " Pop: " + cp.Population() + "\n");
            writer.flush();
        }
        writer.close();

        // Print InOrder traversal
        FileOutputStream fos = new FileOutputStream("out4.txt");
        DataOutputStream osd = 
              new DataOutputStream(new BufferedOutputStream(fos));
        for (Long k: bst.OrderedTraversal("In")) {
            CovidPlace cp = bst.get(k);
            osd.writeBytes("New cases: " + cp.NewCases() + " at " + cp.Location() + "/" + cp.Continent() +
                " on " + cp.Date() +
                " Total: " + cp.TotalCases() +
                " Pop: " + cp.Population() + "\n");
        }
        osd.close();
*/


    }
} 
