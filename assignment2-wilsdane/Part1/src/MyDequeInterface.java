public interface MyDequeInterface<T> {
    // Inserts the specified element at the front of the deque.
    public void enqueueFirst(T value);

    // Inserts the specified element at the end of the deque.
    public void enqueueLast(T value);

    // Returns the first element
    public T dequeFirst();

    // Returns the last element
    public T dequeLast();

    // The above operations should run under a constant time

    // Removes the element at the specified position in the deque.
    // The index of the first item is 0
    // The index of the last item is size()-1
    public void removeAt(int index);

    // Returns the size of the deque
    public int size();

    // Returns the deque elements as an array
    public T[] toArray();
}
