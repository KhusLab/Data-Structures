import static org.junit.jupiter.api.Assertions.*;

class AVLTreeTest {
    @org.junit.jupiter.api.Test
    void testCase1() {
        AVLTree<Integer> avlTree = new AVLTree<>();
        for(int i = 1000; i > 0; i-- ) {
            avlTree.insert(i);
        }
        for(int i = 1000; i > 0; i-- ) {
            assertTrue(avlTree.contains(i));
        }
        System.out.println(avlTree.treeHeight());
    }

}