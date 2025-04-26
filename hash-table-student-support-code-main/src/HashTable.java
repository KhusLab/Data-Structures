import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;


public class HashTable<K,V> implements Map<K,V> {

    class Entry {
        Entry(K k, V v) { key = k; value = v; }
        K key; V value;
    };

    protected ArrayList<LinkedList<Entry>> table;

    protected int hash(K key) {
        return (key.hashCode() % table.size() + table.size()) % table.size();
    }

    public HashTable(int table_size) {
        table = new ArrayList<>(table_size);
        for (int i = 0; i < table_size; i++) {
            table.add(new LinkedList<Entry>());
        }
    }

    public boolean containsKey(K key) {
        int index = hash(key);
        for (Entry entry : table.get(index)) {
            if (entry.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public V get(K key) throws Exception {
        int index = hash(key);
        for (Entry entry : table.get(index)) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
                throw new Exception("there is no entry with key " + key);

    }

    public void put(K key, V value) {
        int index = hash(key);
        for (Entry entry : table.get(index)) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update existing entry
                return;
            }
        }
        table.get(index).add(new Entry(key, value)); // Add new entry
    }

    public void remove(K key) {
        int index = hash(key);
        Iterator<Entry> iterator = table.get(index).iterator();
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            if (entry.key.equals(key)) {
                iterator.remove(); // Remove the entry
                return;
            }
        }
    }
}
