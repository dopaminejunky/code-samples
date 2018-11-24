
/**
 * Write a description of class UniqueTree here.
 *
 * @author Roger Robertson Jr.
 * @version 0.1
 */
public class UniqueTree<E extends Comparable<E>> {
    
    /** the root node of the tree */
    private UniqueNode<E> root;
    private int count;

    /**
     * Constructor for objects of class UniqueTree
     */
    public UniqueTree() {
        root = null;
    }
    
    /**
     * Adds a new node to the tree
     *
     * @param newNodeData the data to add to the tree
     * @param position the position in the master array
     */
    public void add(E newNodeData, int position) {
        root = add(newNodeData, root, position);
    }
    
    /**
     * Adds a new node to the binary tree.  It begins the search for the right spot at the specified point in the tree.  
     * This is the private, recursive helper function that actually does the work.
     * 
     * @param newNodeData the value to be added to the new node's data field
     * @param startNode the existing tree node at which to start searching for the proper spot for the data
     * @param position the position of the object in the master array
     * @return the node for the next recursive call
     */
    private UniqueNode<E> add(E newNodeData, UniqueNode<E> startNode, int position) {
        // Uses the "x = change(x)" concept
        if (startNode == null) {
            UniqueNode<E> newNode = new UniqueNode<E>(newNodeData, position);
            startNode = newNode;
        } else if (newNodeData.compareTo(startNode.data) < 0) {
            startNode.left = add(newNodeData, startNode.left, position);
        } else {
            startNode.right = add(newNodeData, startNode.right, position);
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
    // private E find(UniqueNode<E> startNode, E searchData) {
        // if (searchData.compareTo(startNode.data) < 0) {
            // find(startNode.left, searchData);
        // } else if (searchData.compareTo(startNode.data) > 0) {
            // find(startNode.right, searchData);
        // } else if (searchData.compareTo(startNode.data) == 0) {
            // return startNode.data;
        // }
        // return startNode.data;
    // }
    
    /**
     * Get position data
     * @return an in order traverse of position data
     */
    public int[] getPositionData() {
        int[] result = new int[size() + 1];
        count = 0;
        return getPositionData(root, result);
    }
    
    /**
     * Private helper for getting position data
     * @param startNode the beginning node
     * @return int array of positions
     */
    private int[] getPositionData(UniqueNode<E> startNode, int[] result) {
        
        if (startNode != null) {
            getPositionData(startNode.left, result);
            result[count] = startNode.position;
            count++;
            getPositionData(startNode.right, result);
            
        }
        return result;
    }
    
    /**
     * Size of the tree
     * @return the size of the tree
     */
    public int size() {
        return size(root);
    }
    
    /**
     * Helper method for size
     * @param startNode the beginning node
     * @return the size of the tree
     */
    private int size(UniqueNode<E> startNode) {
        if (startNode == null) {
            return 0;
        }
        return size(startNode.left) + 1 + size(startNode.right);
    }
    
    
    /**
     * Node class for a unique tree
     * @author Roger Robertson Jr.
     * @version 0.1
     */
    private class UniqueNode<E> {
        
        /** the data contained in the node */
        public E data;
        /** the position of the data in the master array */
        public int position;
        /** the left node pointer */
        public UniqueNode<E> left;
        /** the right node pointer */
        public UniqueNode<E> right;
       
        /**
         * UniqueNode constructor
         * @param newData the data to add
         * @param newPosition the position of the data in the master array
         */
        public UniqueNode(E newData, int newPosition) {
            data = newData;
            position = newPosition;
            left = null;
            right = null;
        }
    }
}
