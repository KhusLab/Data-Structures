import static org.junit.jupiter.api.Assertions.*;

class BSTTest {

    @org.junit.jupiter.api.Test
    void testCase1() {
        BST<CustomType> bst = new BST<>();
        CustomType[] objects = {
                new CustomType("CSCI C-343"),
                new CustomType("C 343"),
                new CustomType("C343")
        };

        for (CustomType obj : objects) {
            bst.insert(obj);
        }
        CustomType testObject = new CustomType("43");
        assertFalse( bst.contains(testObject));
        for (CustomType obj : objects) {
            assertTrue( bst.contains(obj));
        }
    }
}