import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class LinearProbingHashTableTest {
//commit both?
    @Test
    void testInsertAndSearchBasic() {
        LinearProbingHashTable table = new LinearProbingHashTable(10);
        table.insert(5);
        table.insert(15); // causes collision with 5 if table size is 10
        assertTrue(table.search(5));
        assertTrue(table.search(15));
        assertFalse(table.search(25));
    }

    @Test
    void testDuplicateInsert() {
        LinearProbingHashTable table = new LinearProbingHashTable(10);
        table.insert(3);
        table.insert(3); // inserting same key again
        assertTrue(table.search(3));
    }

    @Test
    void testFullTablePerformance() {
        int size = 1_000_003; // prime number larger than 1 million
        LinearProbingHashTable table = new LinearProbingHashTable(size);

        long start = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) {
            table.insert(i);
        }
        for (int i = 0; i < 1_000_000; i++) {
            assertTrue(table.search(i));
        }
        long end = System.nanoTime();
        double elapsedSeconds = (end - start) / 1e9;

        assertTrue(elapsedSeconds < 1.0, "Search should complete in under 1 second");
    }
}
