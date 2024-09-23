// lab1-2
import java.util.Iterator;
import java.util.NoSuchElementException;


public class Stack<Item> implements Iterable<Item> {

    private Node<Item> first;    // top of the stack 

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;

        public Node(Item item) {
            this.item = item;
            this.next = null;
        }
    }

    /*
     * Initializes an empty stack
     */
    public Stack() {
        first = null;
    }

    /*
     * Returns true if this stack is empty.
     *
     */
    public boolean isEmpty() {
        return first == null;
    }

    /*
     * inserts the new item at the top of the stack 
     *
     */
    public void push(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>(item);
        first.next = oldfirst;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        return item;
    }

    /*
     * Prints a string representation of this list.
     *
     */
/*
    public void Print() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        System.out.println("List is " + s.toString());
    } 
*/
    /*
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     *
     * @return an iterator that iterates over the items in this queue in FIFO order
     */
    public Iterator<Item> iterator()  {
        return new ListIterator(first);  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> head) {
            current = head;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }  
}
