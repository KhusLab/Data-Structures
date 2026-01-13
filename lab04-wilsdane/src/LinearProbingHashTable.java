public class LinearProbingHashTable {
    // Implement your solution here
    private int[] table;
    private int size;
    private static final int EMPTY = Integer.MIN_VALUE;

    public LinearProbingHashTable(int capacity) {
        size = capacity;
        table = new int[size];
        for (int i = 0; i < size; i++) {
            table[i] = EMPTY;
        }
    }
//ignore this line, commit both?
    private int hash(int key) {
        return Math.abs(key) % size;
    }

    //insert
    public void insert(int key) {
        int index = hash(key);
        while (table[index] != EMPTY) {
            if (table[index] == key) return; // avoiding dupes
            index = (index + 1) % size;
        }
        table[index] = key;
    }

    //search to see if a key exists
    public boolean search(int key) {
        int index = hash(key);
        int startIndex = index;
        while (table[index] != EMPTY) {
            if (table[index] == key) return true;
            index = (index + 1) % size;
            if (index == startIndex) break; // full loop
        }
        return false;
    }
}
