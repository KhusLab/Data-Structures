public abstract class MyDeque implements MyDequeInterface {
    private class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
            this.prev = this.next = null;
        }
    }

    private Node head, tail;
    private int size;

    public MyDeque() {
        head = tail = null;
        size = 0;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public int removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }
        int data = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null; // deque is empty now
        }
        size--;
        return data;
    }

    public int removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }
        int data = tail.data;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null; // deque is empty now
        }
        size--;
        return data;
    }

    public int peekFirst() {
        if (isEmpty()) {
           // int data= tail.data;
            throw new RuntimeException("Deque is empty");
        }
        return head.data;
    }

    public int peekLast() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty");
        }
        return tail.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}