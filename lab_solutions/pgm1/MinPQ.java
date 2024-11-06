// taken from Algorithms, 4th edition
import java.util.NoSuchElementException;

public class MinPQ<Key extends Comparable<Key>> {
    private Key[] pq;          // elements
    private int n;             // number of elements

    // set inititial size of heap to hold size elements
    public MinPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity+1];
        n = 0;
    }

    public boolean isEmpty() { return n == 0;  }
    public int size()        { return n;       } 
    public Key delMin()      { return pq[--n]; }

    public void insert(Key key) {
        // first have to check if key is already in minPQ
        for (int j = 0; j < n; j++) {
            if (pq[j].compareTo(key) == 0) {
                return;
            }
        } 
        int i = n-1;
        while (i >= 0 && key.compareTo(pq[i]) > 0) {
            pq[i+1] = pq[i];
            i--;
        }
        pq[i+1] = key;
        n++;
    }
}
