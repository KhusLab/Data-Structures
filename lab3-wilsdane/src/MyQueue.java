public class MyQueue<T> {
    private Node<T> head;
    private Node<T> tail;

    public MyQueue() {
        //head and tail
        head = null;
        tail = null;
    }
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data, null);
        //start the queue
        if (tail == null) {
            // Queue is empty
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
    }
    public T dequeue() {
        //check if there is anything
        if (head == null) {
            return null;
        }
        T value = head.getValue();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        return value;
    }
}
