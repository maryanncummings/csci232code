// taken from Algorithms, 4th edition by Sedgewick and Wayne

public class LinkedList<Item>{

    private Node<Item> head;  
    private Node<Item> cur;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;

        public Node(Item item) {
            this.item = item;
            this.next = null;
        }
    }

    public LinkedList() {
        head = null;
        cur = head;
    }

    public Item getCurData() {
        if (cur != null) {
            return cur.item;
        }
        else {
            return null;
        } 
    }
        

    public boolean nextData() {
        if (cur != null) {
            cur = cur.next;
        }
        return (cur != null); // false means no next data to move to
                              // in other words, at end of list
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insert(Item item) {
        Node<Item> oldhead = head;
        head = new Node<Item>(item);
        head.next = oldhead;
        cur = head;
    }
}
