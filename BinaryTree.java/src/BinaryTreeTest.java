import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class BinaryTreeTest {

    BinaryTree<Integer> T;

    @BeforeEach
    public void setUp() throws Exception {
        ArrayList<Integer> testData = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            testData.add(i);
        }
        T = new BinaryTree<>(testData);
    }

    @Test
    public void test() {
        beginTest();
        rbeginTest();
    }

    private void beginTest() {
        BinaryTree<Integer>.Iter iter = T.begin();
        assertEquals("1", iter.get().toString());
        iter.advance();
        assertEquals("2", iter.get().toString());
        iter.advance();
        assertEquals("3", iter.get().toString());
    }

    private void rbeginTest() {
        BinaryTree<Integer>.Iter iter = T.rbegin();
        assertEquals("7", iter.get().toString());
        iter.retreat();
        assertEquals("6", iter.get().toString());
        iter.retreat();
        assertEquals("5", iter.get().toString());
    }
}

