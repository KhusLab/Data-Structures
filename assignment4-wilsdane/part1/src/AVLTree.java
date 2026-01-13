public class AVLTree<T extends Comparable<T>> {
    private Node<T> root;

    // Height difference allowed
    private static final int ALLOWED_IMBALANCE = 1;

    private int height(Node<T> node) {
        return node ==null? -1: node.getHeight();
    }

    public int treeHeight() {
        return height(root);
    }

    public void insert(T value){
        root = insert(value, root);
    }

    // Insert into node
    private Node<T> insert(T value, Node<T> node) {
        if (node == null) {
            return new Node<>(value, null, null);
        }
        int result = value.compareTo(node.getValue());
        if (result < 0) {
            node.setLeft(insert(value, node.getLeft()));
        } else if (result > 0) {
            node.setRight(insert(value, node.getRight()));
        }
        return balance(node);
    }

    // Balance a subtree
    private Node<T> balance(Node<T> node) {
        if (node == null) {
            return null;
        }

        if (height(node.getLeft()) - height(node.getRight()) > ALLOWED_IMBALANCE) {
            if (height(node.getLeft().getLeft()) > height(node.getLeft().getRight()))
                node = rotateWithLeftChild(node);
            else
                node = doubleWithLeftChild(node);
        } else if ( height(node.getRight()) - height(node.getLeft()) > ALLOWED_IMBALANCE) {
            if(height(node.getRight().getRight()) > height(node.getRight().getLeft()))
                node = rotateWithRightChild(node);
            else
                node = doubleWithRightChild(node);
        }
        node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
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

    private Node<T> rotateWithLeftChild(Node<T> k2) {
        // Implement your solution here
        // Single rotation with left child
        Node<T> k1 = k2.getLeft();
        k2.setLeft(k1.getRight());
        k1.setRight(k2);

        // Update heights
        k2.setHeight(Math.max(height(k2.getLeft()), height(k2.getRight())) + 1);
        k1.setHeight(Math.max(height(k1.getLeft()), height(k1.getRight())) + 1);

        return k1;
    }

    private Node<T> doubleWithRightChild(Node<T> k3) {
        // Implement your solution here
        // Double rotation: right-left
        k3.setRight(rotateWithLeftChild(k3.getRight()));
        return rotateWithRightChild(k3);
    }

    // To implement
    private Node<T> rotateWithRightChild(Node<T> k2) {
        // Implement your solution here
        // Single rotation with right child
        Node<T> k1 = k2.getRight();
        k2.setRight(k1.getLeft());
        k1.setLeft(k2);

        // Update heights
        k2.setHeight(Math.max(height(k2.getLeft()), height(k2.getRight())) + 1);
        k1.setHeight(Math.max(height(k1.getLeft()), height(k1.getRight())) + 1);

        return k1;
    }

    private Node<T> doubleWithLeftChild(Node<T> k3) {
        // Implement your solution here
        // Double rotation: left-right
        k3.setLeft(rotateWithRightChild(k3.getLeft()));
        return rotateWithLeftChild(k3);
    }

}