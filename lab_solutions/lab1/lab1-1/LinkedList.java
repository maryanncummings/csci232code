// taken from Algorithms, 4th edition by Sedgewick and Wayne

public class LinkedList<E>{

    private Node<E> head;  
    private Node<E> cur;

    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedList() {
        head = null;
        cur = head;
    }

    public void printListDataType() {
        if (head != null) {
            System.out.println("The data type for the data in this " +
                                "linked list is " +
                            head.data.getClass().getSimpleName());
        }
    }


    public E getCurData() {
        if (cur != null) {
            return cur.data;
        }
        else {
            return null;
        } 
    }
        
    public boolean atEndOfList() {
        if (cur != null) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean nextData() {
        if (cur != null) {
            cur = cur.next;
        }
        return (cur != null); // false means no next data to move to
                              // in other words, at end of list
    }

    public void GoToHead() {
        cur = head;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insert(E data) {
        Node<E> oldhead = head;
        head = new Node<E>(data);
        head.next = oldhead;
        cur = head;
    }

    public void delete(E data) {

        Node<E> prev = null; // need this to connect the previous node to the
                             // next node;  this will remove the current node

        cur = head;
        prev = null;  // need this to connect the previous node to the next
                      // node;  this will remove the current node
        while (cur != null) {
            if (cur.data.equals(data)) {
                if (cur == head) {
                    head = cur.next;
                }
                else {
                    prev.next = cur.next;
                }
            }
            prev = cur;
            cur = cur.next;
        }
    }
}
