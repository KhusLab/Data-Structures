public class MyLinkedList<AnyType> {
    // Implement your solution here
    private Node<AnyType> head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }
    //add items value and position
    public void add(AnyType value, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        Node<AnyType> newNode = new Node<>(value);

        if (position == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<AnyType> current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    public String reverseList() {
        return reverseHelper(head);
    }
    //return a single string
    //"\n" separation
    private String reverseHelper(Node<AnyType> node) {
        if (node == null) {
            return "";
        }
        String rest = reverseHelper(node.next);
        return (rest.isEmpty() ? "" : rest + "\n") + node.data;
    }
}
