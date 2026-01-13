public class Node<T extends Comparable<T>> {
    private T value;
    private Node right;
    private Node left;
    private int height;
    public Node(T value, Node left, Node right) {
        this.value = value;
        this.right = right;
        this.left = left;
        this.height = 0;
    }
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
    public Node getRight() {
        return right;
    }
    public void setRight(Node right) {
        this.right = right;
    }
    public Node getLeft() {
        return left;
    }
    public void setLeft(Node left) {
        this.left = left;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
}
