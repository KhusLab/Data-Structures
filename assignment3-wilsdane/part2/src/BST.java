public class BST<T extends Comparable<T>> {

    // Internal node class
    private class Node {
        T value;
        Node left, right;

        Node(T value) {
            this.value = value;
        }
    }

    private Node root; // Root of the BST

    // Insert a value into the BST
    public void insert(T value) {
        //Your solution goes here
        root = insertRec(root, value);
    }

    // Helper method to insert recursively
    private Node insertRec(Node node, T value) {
        if (node == null) return new Node(value);
        if (value.compareTo(node.value) < 0) {
            node.left = insertRec(node.left, value); // Go left
        } else if (value.compareTo(node.value) > 0) {
            node.right = insertRec(node.right, value); // Go right
        }
        return node; // Do nothing if duplicate
    }

    // Check if the tree contains a given value
    public boolean contains(T value) {
        //Your solution goes here
        return containsRec(root, value);
    }

    // Helper method to search recursively
    private boolean containsRec(Node node, T value) {
        if (node == null) return false;
        int cmp = value.compareTo(node.value);
        if (cmp == 0) return true; // Found
        else if (cmp < 0) return containsRec(node.left, value); // Search left
        else return containsRec(node.right, value); // Search right
    }
}