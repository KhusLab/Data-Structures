import static org.junit.jupiter.api.Assertions.*;

class BSTTest {

    @org.junit.jupiter.api.Test
    void testCase1() {
        // Instantiate the tree
        BST<CustomType> bst = new BST<>();

        // Create and insert comparable objects
        CustomType[] objects = {
                new CustomType("CSCI C-343"),
                new CustomType("C 343"),
                new CustomType("C343")
        };
        for (CustomType obj : objects) {
            bst.insert(obj);
        }

        // Remove the objects and test
        for (CustomType obj : objects) {
            bst.remove(obj);
            assertFalse(bst.contains(obj));

        }
    }

    @org.junit.jupiter.api.Test
    void testRemoveRootWithTwoChildren() {
        BST<String> bst = new BST<>();
        bst.insert("M"); // Root
        bst.insert("C"); // Left child
        bst.insert("T"); // Right child

        bst.remove("M");
        assertFalse(bst.contains("M"));
        assertTrue(bst.contains("C"));
        assertTrue(bst.contains("T"));
    }

    @org.junit.jupiter.api.Test
    void testRemoveSingleNodeTree() {
        BST<String> bst = new BST<>();
        bst.insert("Z");

        bst.remove("Z");
        assertFalse(bst.contains("Z"));
    }
}