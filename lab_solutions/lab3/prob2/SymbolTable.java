// Taken from algorithms, 4th edition by Sedgewick and Wayne

public class SymbolTable<Key extends Comparable<Key>, Value> {

    private int n;           // number of key-value pairs
    private Node first;      // the linked list of key-value pairs

    // a helper linked list data type
    private class Node {
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val)  {
            this.key  = key;
            this.val  = val;
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public SymbolTable() {
    }

     // Returns the number of key-value pairs in this symbol table.
    public int size() {
        return n;
    }

    /**
     * Returns true if this symbol table is empty.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if this symbol table contains the specified key.
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }

    /**
     * Returns the value associated with the given key in this symbol table.
     */
    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key))
                return x.val;
        }
        return null;
    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old 
     * value with the new value if the symbol table already contains the specified key.
     */
    public void put(Key key, Value val) {

        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        Node old_first = first;
        first = new Node(key, val);
        first.next = old_first;
        n++;
    }

    /**
     * Removes the specified key and its associated value from this symbol table     
     * (if the key is in this symbol table).    
     */
    public void delete(Key key) {
        // if key is found in the first node
        if (first.key == key) {
            // delete the first node and make the second node now first
            first = first.next;
        }
        else {
            Node prev = null;
            // the node we want to delete is somewhere else in the list
            for (Node x = first; x != null; x = x.next) {
                if (key.equals(x.key)) {
                    prev.next = x.next;
                }
                prev = x;
            }
        }
        return;
    }


    /**
     * Returns all keys in the symbol table as an {@code Iterable}.
     */
    public Iterable<Key> keys()  {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }

    public Key min() {
        Key m = first.key;
        for (Node x = first; x != null; x = x.next) {
            if (x.key.compareTo(m) < 0) {
                m = x.key;
            }
        }
        return m;
    }

    public Key max() {
        Key m = first.key;
        for (Node x = first; x != null; x = x.next) {
            if (x.key.compareTo(m) > 0) {
                m = x.key;
            }
        }
        return m;
    }
}

