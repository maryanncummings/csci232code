// same as 13-1, Example 13-2, StackOfStrings.java
// Taken from Algorithms, 4th edition, by Sedgewick and Wayne

import java.util.Iterator;
import java.util.NoSuchElementException;


public class StackOfStrings {
    private Node top;     // top of stack
    private int n;        // size of the stack

    // helper linked list class
    private static class Node {
        private String item;
        private Node next;
    }

    /*
     * Initializes an empty stack.
     */
    public StackOfStrings() {
        top = null;
        n = 0;
    }

    /*
     * Returns true if this stack is empty.
     */
    public boolean isEmpty() {
        return top == null;
    }

    /*
     * Returns the number of items in this stack.
     */
    public int size() {
        return n;
    }

    /*
     * Adds the item to this stack.
     */
    public void push(String item) {
        Node oldtop = top;
        top = new Node();
        top.item = item;
        top.next = oldtop;
        n++;
    }

    /*
     * Removes and returns the item most recently added to this stack.
     */
    public String pop() {
        String item = top.item;  // save item to return
        top = top.next;          // delete top node
        n--;
        return item;             // return the saved item
    }


    /**
     * Returns (but does not remove) the item most recently added to this stack.
     *
     * @return the item most recently added to this stack
     * @throws NoSuchElementException if this stack is empty
     */
    public String peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return top.item;
    }

}
