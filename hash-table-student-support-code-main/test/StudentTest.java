import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    @Test
    public void test() throws Exception {
        HashTable<String, Integer> hashTable = new HashTable<>(10);

        // Test adding and retrieving a single entry
        hashTable.put("key1", 1);
        assertEquals(Integer.valueOf(1), hashTable.get("key1"));

        // Test adding multiple entries
        hashTable.put("key2", 2);
        hashTable.put("key3", 3);
        assertEquals(Integer.valueOf(1), hashTable.get("key1"));
        assertEquals(Integer.valueOf(2), hashTable.get("key2"));
        assertEquals(Integer.valueOf(3), hashTable.get("key3"));

        // Test updating an entry
        hashTable.put("key1", 10);
        assertEquals(Integer.valueOf(10), hashTable.get("key1"));

        // Test containsKey method
        assertTrue(hashTable.containsKey("key1"));
        assertTrue(hashTable.containsKey("key2"));
        assertFalse(hashTable.containsKey("key4"));

        // Test removing an entry
        hashTable.remove("key1");
        assertFalse(hashTable.containsKey("key1"));
        assertThrows(Exception.class, () -> {
            hashTable.get("key1");
        });

        // Test collision handling by inserting keys that should hash to the same index
        hashTable.put("collisionKey1", 100);
        hashTable.put("collisionKey2", 200); // Assume this collides with collisionKey1
        assertEquals(Integer.valueOf(100), hashTable.get("collisionKey1"));
        assertEquals(Integer.valueOf(200), hashTable.get("collisionKey2"));

        // Test rehashing (if applicable)
        for (int i = 0; i < 20; i++) {
            hashTable.put("key" + i, i);
        }
        for (int i = 0; i < 20; i++) {
            assertEquals(Integer.valueOf(i), hashTable.get("key" + i));
        }

        // Test handling of null keys (should throw an exception if null keys are not allowed)
        assertThrows(Exception.class, () -> {
            hashTable.put(null, 5);
        });

        // Test handling of null values (should be allowed or properly handled)
        hashTable.put("nullValueKey", null);
        assertNull(hashTable.get("nullValueKey"));

        // Test removing non-existent key (should not crash or throw unintended exceptions)
        assertDoesNotThrow(() -> {
            hashTable.remove("nonExistentKey");
        });
    }
}

