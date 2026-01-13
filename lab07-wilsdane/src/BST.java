// Generic BST class
public class BST<T extends Comparable<T>> {
    private Node<T> root;

    // Insert a value into the BST
    public void insert(T value) {
        root = insert(root, value);
    }

    private Node<T> insert(Node<T> node, T value) {
        if (node == null) return new Node<>(value);
        int result = value.compareTo(node.getValue());
        if (result < 0) {
            node.setLeft(  insert(node.getLeft(), value));
        } else if (result > 0) {
            node.setRight( insert(node.getRight(), value));
        }
        return node;
    }


    public boolean contains(T value) {
        return contains(value, root);
    }
    public boolean contains(T value, Node<T> node) {
        if(node == null) {
            return false;
        }
        int result = value.compareTo(node.getValue());
        if(result < 0)
            return contains(value, node.getLeft());
        else if (result > 0)
            return contains(value, node.getRight());
        else return true;
    }

    /**
     * Item removal public method
     * @param value the item to be removed
     */
    public void remove(T value) {
        root = remove(value, root);
    }

    /**
     * Item removal method
     * @param value the item to be removed
     * @param node the root of the subtree
     * @return the new root of the subtree
     */
    private Node<T> remove(T value, Node<T> node) {
        // Implement your solution here
        if (node == null) return null;

        int cmp = value.compareTo(node.getValue());
        if (cmp < 0) {
            node.setLeft(remove(value, node.getLeft()));
        } else if (cmp > 0) {
            node.setRight(remove(value, node.getRight()));
        } else {
            // Node to remove found
            if (node.getLeft() == null) return node.getRight();
            if (node.getRight() == null) return node.getLeft();

            // Two children: find the in-order successor
            Node<T> successor = findMin(node.getRight());
            node.setValue(successor.getValue());
            node.setRight(remove(successor.getValue(), node.getRight()));
        }
        return node;
    }

    private Node<T> findMin(Node<T> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }


}
