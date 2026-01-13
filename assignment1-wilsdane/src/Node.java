public class Node<AnyType> {
    // Implement your solution here
    AnyType data;
    Node<AnyType> next;

    public Node(AnyType data) {
        this.data = data;
        this.next = null;
    }
}
