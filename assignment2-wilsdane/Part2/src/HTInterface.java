public interface HTInterface<K, T> {

    // Inserts a key-value pair in the hash table
    public void put(K key, T value);

    // Returns a value only
    public T get(K key);
}
