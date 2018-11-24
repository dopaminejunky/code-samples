
/**
 * Write a description of class NonUniqueTree here.
 *
 * @author Roger Robertson Jr.
 * @version 0.1
 */
public class NonUniqueTree<E extends Comparable<E>> {
    
    /** the root node of the nonunique tree */
    private NonUniqueNode<E> root;
    private int count;
    private int nodeCount;
    /**
     * Constructor for objects of class NonUniqueTree
     */
    public NonUniqueTree() {
        root = null;
        nodeCount = 0;
    }
    
    /**
     * Adds a new node to the tree
     *
     * @param newNodeData the data to add to the tree
     * @param position the position in the master array
     */
    public void add(E newNodeData, int position) {
        root = add(newNodeData, root, position);
        nodeCount++;
    }
    
    /**
     * Adds a new node to the binary tree.  It begins the search for the right spot at the specified point in the tree.  
     * This is the private, recursive helper function that actually does the work.
     * 
     * @param newNodeData the value to be added to the new node's data field
     * @param startNode the existing tree node at which to start searching for the proper spot for the data
     * @param position the position in the master array
     * @return node for another recursive call
     */
    private NonUniqueNode<E> add(E newNodeData, NonUniqueNode<E> startNode, int position) {
        
        if (startNode == null) {
            NonUniqueNode<E> newNode = new NonUniqueNode<E>(newNodeData, position);
            startNode = newNode;
        } else if (newNodeData.compareTo(startNode.data) < 0) {
            startNode.left = add(newNodeData, startNode.left, position);
        } else if (newNodeData.compareTo(startNode.data) > 0) {
            startNode.right = add(newNodeData, startNode.right, position);
        } else {
            if (startNode.same == null) {
                startNode.same = new SameNode(position);
            } else {
                SameNode same = new SameNode(position);
                same.same = startNode.same;
                startNode.same = same;
            }
        }
        return startNode;
    }
    
    // /**
     // * Get data from a node
     // * @param searchData data sought
     // * @return the node data
     // */
    // public E find(E searchData) {
        // return find(root, searchData);
    // }
    
    // /**
     // * Private helper function for getData
     // * @param startNode the starting node
     // * @param searchData the data sought
     // * @return the node data
     // */
    // private E find(NonUniqueNode<E> startNode, E searchData) {
        // if (searchData.compareTo(startNode.data) < 0) {
            // find(startNode.left, searchData);
        // } else if (searchData.compareTo(startNode.data) > 0) {
            // find(startNode.right, searchData);
        // }
        // return startNode.data;
    // }
    
    /**
     * Get position data
     * @return an int array of positions
     */
    public int[] getPositionData() {
        
        int[] result = new int[nodeCount];
        return getPositionData(root, result);
    }
    
    /**
     * Private helper for getting position data
     * @param startNode the beginning of the traverse
     * @return int array of positions
     */
    private int[] getPositionData(NonUniqueNode<E> startNode, int[] result) {
        if (startNode != null) {
            getPositionData(startNode.left, result);
            result[count] = startNode.position;
            count++;
            SameNode current = startNode.same;
            while (current != null) {
                result[count] = current.position;
                count++;
                current = current.same;
            }
            getPositionData(startNode.right, result);
        }
        return result;
    }

    /**
     * Size of the tree
     * @return size of the tree
     */
    public int size() {
        return size(root);
    }
    
    /**
     * Private helper method for size()
     * @param startNode the starting NonUniqueNode
     * @return the size of the NonUniqueNode portion of the tree
     */
    private int size(NonUniqueNode<E> startNode) {
        if (startNode == null) {
            return 0;
        }
        return size(startNode.left) + 1 + size(startNode.right) + size(startNode.same);
    }
    
    /**
     * Private helper method for size()
     * @param startNode the startin SameNode
     * @return the size of the SameNode portion of the tree;
     */
    private int size(SameNode startNode) {
        if (startNode == null) {
            return 0;
        }
        return size(startNode.same);
    }
    
    /**
     * Node class for nonunique tree
     * @author Roger Robertson Jr.
     * @version 0.1
     */
    private class NonUniqueNode<E> {
    
        /** the data contained in the node */
        public E data;
        /** the position of the data */
        public int position;
        /** the left node pointer */
        public NonUniqueNode<E> left;
        /** the right node pointer */
        public NonUniqueNode<E> right;
        /** samenode pointer for indicating duplicates */
        public SameNode same;
        
        /**
        * NonUniqueNode constructor overload
        * @param newData the data contained in the node
        * @param newPosition the position of the data in the master array
        */
        public NonUniqueNode(E newData, int newPosition) {
            data = newData;
            position = newPosition;
            left = null;
            right = null;
            same = null;
        }
    }
        
        
    /**
     * Duplicate node class
     * @author Roger Robertson Jr.
     * @version 0.1
     */
    private class SameNode {
        
        /** the position of the duplicate data */
        public int position;
        /** the next samenode */
        public SameNode same;
        
        /**
         * Zero parameter constructor for SameNode
         */
        public SameNode() {
            position = 0;
            same = null;
        }
        
        /**
         * Overloaded constructor taking a position
         * @param newPosition the position in the master array
         */
        public SameNode(int newPosition) {
            position = newPosition;
            same = null;
        }
    }
    
}
