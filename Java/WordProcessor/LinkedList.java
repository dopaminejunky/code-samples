import java.io.Serializable;
/**
 * Doubly linked list class
 *
 * @author Roger Robertson Jr.
 * @version 0.1
 */
public class LinkedList<E> implements Serializable { 
    
    /** the front pointer */
    private Node<E> front;
    /** the end pointer */
    private Node<E> end;
    
    /**
     * Constructor for objects of class LinkedList
     */
    public LinkedList() {
        front = null;
        end = null;
    }
    
    /**
     * Add at the end of the list
     * @param newData the new data for the created node
     */
    public void add(E newData) {
        if (front == null && end == null) {
            front = new Node<E>(newData);
            end = front;
        } else {
            Node<E> current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<E>(newData, null, current);
            end = current.next;
        }    
    }
    
    /**
     * Add at index
     * @param newData the new data
     * @param index the index where the data should be added; must be valid
     */
    public void add(E newData, int index) {
        Node<E> newNode = new Node<E>(newData);
        int count = 0;
        if (checkIndex(index)) {
            Node<E> current = front;
            while (count < index) {
                current = current.next;
                count++;
            }
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
            newNode.next = current;
        } else {
            throw new IllegalStateException("Invalid index!");
        }
    }
    
    /**
     * Remove a node at an index
     * @param index the desired node to remove
     */
    public void remove(int index) {
        Node<E> current = front;
        int count = 0;
        if (index == 0) {
            front = current.next;
            current.next.prev = null;
        } else if (index == 1) {
            front.next = null;
            current.prev = null;
        } else if (checkIndex(index)) { 
            while (count < index) {
                current = current.next;
                count++;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
    }
    
    /**
     * Get node data at index
     * @param index the node to get
     * @return data from desired node
     */
    public E get(int index) {
        int count = 0;
        Node<E> current = front;
        while (count != index) {
            current = current.next;
            count++;
        }
        return current.data; 
    }
    
    /**
     * Node count
     * @returns the number of nodes in the list
     */
    public int size() {
        int count = 0;
        Node<E> current = front;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }
    
    /**
     * Move node up
     * Throws IllegalStateException if attempting to move out of bounds
     * @param index the index of the node to move up
     */
    public void moveUp(int index) {
        Node<E> current = front;
        int count = 0;
        if (index == 0) {
            throw new IllegalStateException("Already at the top!");
        }
        while (count != index && checkIndex(index)) {
            current = current.next;
            count++;
        }
        current.prev.prev.next = current;
        current.next = current.prev;
        current.prev.next = current.next;
        current.prev = current.prev.prev;
    }
    
    /**
     * Move node down
     * Throws IllegalStateException if attempting to move out of bounds
     * @param index the index of the node to move down
     */
    public void moveDown(int index) {
        Node<E> current = front;
        int count = 0;
        if (index == size() - 1) {
            throw new IllegalStateException("Already at the bottom!");
        }
        while (count != index && checkIndex(index)) {
            current = current.next;
            count++;
        }
        current.next.next = current;
        current.next.next.prev = current;
        current.next.prev = current.prev;
        current.next = current.next.next;
    }
    
    /**
     * Check that a given index does not exceed size bounds
     * @param index the index to check
     * @return if index is within bounds
     */
    private boolean checkIndex(int index) {
        if (index < size()) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Private Node class for use in LinkedList
     * @author Roger Robertson Jr.
     * @version 0.1
     */
    private class Node<E> implements Serializable {
        
        /** the data contained in the node */
        public E data;
        /** the next node pointer */
        public Node<E> next;
        /** the previous node pointer */
        public Node<E> prev;
        
        /**
         * Constructor with no parameters
         */
        public Node() {
            this(null, null, null);
        }
        
        /**
         * Constructor with data and no pointers
         * @param newData the new data for the node
         */
        public Node(E newData) {
            this(newData, null, null);
        }
        
        /**
         * Constructor with data and a next pointer
         * @param newData the new data
         * @param newNext the next node pointer
         */
        public Node(E newData, Node<E> newNext) {
            this(newData, newNext, null);
        }
        
        /**
         * Master constructor
         * @param newData the new data
         * @param newNext the next node pointer
         * @param newPrev the previous node pointer
         */
        public Node(E newData, Node<E> newNext, Node<E> newPrev) {
            this.data = newData;
            this.next = newNext;
            this.prev = newPrev;
        }
    }
}
