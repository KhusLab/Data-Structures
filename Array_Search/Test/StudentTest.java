import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    public void test() {
        find_first_true_Test();
        find_first_equal_Test();
        find_first_true_sorted_Test();
    }

    @Test
    public void find_first_true_Test(){
        boolean[] A1 = {true, false, true, false, true};
        assertEquals(Search.find_first_true(A1, 1, 3), 2);

        boolean[] A2 = {false, false, false};
        assertEquals(Search.find_first_true(A2, 0, A2.length), A2.length);

        boolean[] A3 = {true, true, true};
        assertEquals(Search.find_first_true(A3, 0, A3.length), 0);

        boolean[] A4 = {false, false, true};
        assertEquals(Search.find_first_true(A4, 0, A4.length), 2);

        boolean[] A5 = {}; // Empty array
        assertEquals(Search.find_first_true(A5, 0, A5.length), A5.length);

        boolean[] A6 = {false, false, false};
        assertEquals(Search.find_first_true(A6, 1, 3), A6.length); // No true in the specified range
    }

    @Test
    public void find_first_equal_Test(){
        int[] A1 = {32, 11, 4, 5, 99, 5, 32, 75};
        assertEquals(Search.find_first_equal(A1, 4), 2);

        int[] A2 = {1, 2, 3, 4, 5};
        assertEquals(Search.find_first_equal(A2, 6), A2.length);

        int[] A3 = {7, 7, 7};
        assertEquals(Search.find_first_equal(A3, 7), 0);

        int[] A4 = {1, 1, 1};
        assertEquals(Search.find_first_equal(A4, 1), 0);

        int[] A5 = {}; // Empty array
        assertEquals(Search.find_first_equal(A5, 1), A5.length);
    }

    @Test
    public void find_first_true_sorted_Test(){
        boolean[] A1 = {false, false, false, true, true, true, true};
        assertEquals(Search.find_first_true_sorted(A1, 1, 5), 3);

        boolean[] A2 = {false, false, false};
        assertEquals(Search.find_first_true_sorted(A2, 0, A2.length), A2.length);

        boolean[] A3 = {true, true, true};
        assertEquals(Search.find_first_true_sorted(A3, 0, A3.length), 0);

        boolean[] A4 = {false, false, true, true};
        assertEquals(Search.find_first_true_sorted(A4, 0, A4.length), 2);

        boolean[] A5 = {}; // Empty array
        assertEquals(Search.find_first_true_sorted(A5, 0, A5.length), A5.length);

        boolean[] A6 = {false, false, false};
        assertEquals(Search.find_first_true_sorted(A6, 1, 3), A6.length); // No true in the specified range
    }
}


