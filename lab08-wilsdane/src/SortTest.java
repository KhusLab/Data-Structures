import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {

    static Integer[] arr;
    static int size = 100 * 1000;
    static long beforeInsertionSort;
    static long afterInsertionSort;
    static long beforeShellSort;
    static long afterShellSort;


    @BeforeAll
    public static void setupBeforeAll() {
        arr = new Integer[size];

        // Average case
        for (int i = size - 1; i >= 0; i--) {
//            arr[i] = i;
            arr[i] = (int) (Math.random() * size);
        }
    }

    // Tests if sort runs with no errors
    @org.junit.jupiter.api.Test
    void testCase1() {


        beforeInsertionSort = System.currentTimeMillis();

        arr = Sort.insertionSort(arr);

        afterInsertionSort = System.currentTimeMillis();


        // Test if insertion sort sorts correctly


        // Check if the array is sorted
        Integer previous = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            assertTrue(arr[i] >= previous);
            previous = arr[i];
        }
    }

    @org.junit.jupiter.api.Test
    void testCase2() {

        // Average case
        for (int i = size - 1; i >= 0; i--) {
//            arr[i] = i;
            arr[i] = (int) (Math.random() * size);
        }

        beforeShellSort = System.currentTimeMillis();

        arr = Sort.shellSort(arr);

        afterShellSort = System.currentTimeMillis();

        // Check if the array is sorted
        int previous = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            assertTrue(arr[i] >= previous);
            previous = arr[i];
        }
    }

    @org.junit.jupiter.api.Test
    void testCase3() {

        // check if shell was faster than insertion
        long difference = (afterShellSort - beforeShellSort) - (afterInsertionSort - beforeInsertionSort);
        System.out.println(difference);
        assertTrue(difference < 0);
    }
}