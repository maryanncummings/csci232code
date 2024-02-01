// Example13-4 - QueueOfStrings.java
// taken from Algorithms, 4th edition by Sedgewick and Wayne

import java.util.Iterator;
import java.util.NoSuchElementException;


public class QueueOfStrings {
    private Node first;    // beginning of queue
    private Node last;     // end of queue
    private int n;               // number of elements on queue

    // helper linked list class
    private static class Node {
        private String item;
        private Node next;
    }

    /*
     * Initializes an empty queue.
     */
    public QueueOfStrings() {
        first = null;
        last  = null;
        n = 0;
    }

    /*
     * Returns true if this queue is empty.
     */
    public boolean isEmpty() {
        return first == null;
    }

    /*
     * Returns the number of items in this queue.
     */
    public int size() {
        return n;
    }

    /*
     * Returns the item least recently added to this queue.
     */
    public String peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }

    /*
     * Adds the item to this queue.
     */
    public void enqueue(String item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        n++;
    }

    /*
     * Removes and returns the item on this queue that was least recently added.
     */
    public String dequeue() {
        String item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }
}
