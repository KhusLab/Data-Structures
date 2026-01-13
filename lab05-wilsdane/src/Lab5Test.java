import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lab5Test {

    @org.junit.jupiter.api.Test
    void greedyActivitySelector() {
        int[] s = {0, 1, 3, 0, 5, 3, 5, 6, 7, 8, 2, 12};
        int[] f = {0, 4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16};
        String result = Lab5.greedyActivitySelector(s, f, 0, 11);
        assertEquals(result, "1,4,8,11,");
    }
    @Test
    void testCase1() {
        int[] s = {0, 1, 3, 5, 0, 8, 5, 8, 9};
        int[] f = {0, 2, 4, 6, 7, 9, 9, 10, 11};
        String result = Lab5.greedyActivitySelector(s, f, 0, 8);
        assertEquals("1,2,3,5,8,", result);
    }

    @Test
    void testCase2() {
        int[] s = {0, 2, 2, 2};
        int[] f = {0, 3, 3, 3};
        String result = Lab5.greedyActivitySelector(s, f, 0, 3);
        assertEquals("1,", result);
    }

    @Test
    void testCase3() {
        int[] s = {0, 1, 2, 3};
        int[] f = {0, 2, 3, 4};
        String result = Lab5.greedyActivitySelector(s, f, 0, 3);
        assertEquals("1,2,3,", result);
    }

    @Test
    void testNoActivities() {
        int[] s = {0};
        int[] f = {0};
        String result = Lab5.greedyActivitySelector(s, f, 0, 0);
        assertEquals("", result);
    }
}