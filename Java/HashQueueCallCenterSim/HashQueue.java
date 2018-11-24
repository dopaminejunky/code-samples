import java.util.HashSet;
/**
 * Write a description of class HashQueue here.
 *
 * @author Roger Robertson Jr.
 * @version 0.1
 */
public class HashQueue<E> {
    
    private Node<E> front;
    
    /**
     * Constructor for objects of class HashQueue
     */
    public HashQueue() {
        front = null;
    }
    
    /**
     * Add at the end of the list
     * @param newData the new data for the created node
     */
    public void add(E newData) {
        if (front == null) {
            front = new Node<E>(newData, null);
        } else {
            Node<E> current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<E>(newData, null);
        }    
    }
    
    /**
     * Peek at the next element
     * @return next element data
     */
    public E peek() {
        Node<E> current = front;
        return current.next.data;
    }
    
    /**
     * Clear the list
     */
    public void clear() {
        front = null;
    }
    
    /**
     * Return true if list is empty
     * @return if the list is empty
     */
    public boolean isEmpty() {
        if (front == null) {
            return true;
        }
        return false;
    }
    
    /**
     * The size method
     * @return number of elements in the queue
     */
    public int size() {
        Node<E> current = front;
        int count = 0;
        while (current.next != null) {
            current = current.next;
            count++;
        }
        return count;
    }
    
    /**
     * Private Node class for use in Queue
     */
    private class Node<E> {
        
        /** the data */
        public E data;
        /** the next node */
        public Node<E> next;
        
        public Node(E newData, Node<E> newNext) {
            data = newData;
            next = newNext;
        }
    }
}
