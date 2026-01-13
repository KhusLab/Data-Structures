public interface Lab4Interface {
    // When implementing this class for Lab 4
    // The class name must be LinearProbingHashTable

    /*
    This method uses the linear probing method to insert
    the keys when a collision happens.
     */
    public void insert(int key);

    /*
    This method searches the hash table to check if
    some key exists and returns a boolean variable accordingly.
    The average case running time must be O(1).
     */
    public boolean search(int key);
}
