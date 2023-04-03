/**
 * CSC 112 LinkedList<T> Spring 2023
 * This class provides a generic singly linked list that  
 * implements the Interable<T> interface.
 *
 * @version 0.1, Apr. 1, 2023
 */

// import java.util.*;

public class LinkedList<T> implements Iterable<T> {
    protected class Node {
        T data;     // data to store in the node
        Node next;  // reference to the next node

        public Node(T data, Node next) { // no <T> placed here
            this.data = data;
            this.next = next;
        }
    }

    Node head = null;

    public LinkedList() { // no <T> placed here, kinda weird
        head = null;
    }

    // add the new methods

    // copy your other LinkedList<T> code here
}
