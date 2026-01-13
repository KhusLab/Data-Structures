import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HeapTest {

    // Create distinct random integers
    Integer[] distinctRandomIntegers(int size) {
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        List<Integer> list = Arrays.asList(arr);
        Collections.shuffle(list);
        arr = list.toArray(new Integer[list.size()]);
        return arr;
    }

    @Test
    public void testCase1() {
        Heap heap = new Heap<Integer>(1000);
        heap.insert(10);
        heap.insert(9);
        heap.insert(8);
        heap.insert(7);
        Comparable[] expected = heap.getHeap();
//        System.out.println(Arrays.toString(expected));
        assertEquals(7, expected[1]);

    }

    @org.junit.jupiter.api.Test
    void testCase2() {
        Heap heap = new Heap<Integer>(1000);
        for (int i = 7; i < 14; i++) {
            heap.insert(i);
        }
        assertEquals(7, heap.deleteMin());
        Comparable[] expected = heap.getHeap();
//        System.out.println(Arrays.toString(expected));
        assertEquals(8, expected[1]);
        assertEquals(12, expected[6]);
    }

    @org.junit.jupiter.api.Test
    void testCase3() {
        int size = 1000;
        Integer[] array = new Integer[size];
        for (int i =0; i < size; i++ ) {
            array[i] = (int)(Math.random()*size);
        }
        Heap heap = new Heap<Integer>(array);
        heap.buildHeap();
        Integer[] arraySorted = new Integer[size];
        Integer previous = Integer.MIN_VALUE;
        for (int i =0; i < size; i++ ) {
            arraySorted[i] = (Integer) heap.deleteMin();
            assertTrue(arraySorted[i] >= previous);
            previous = arraySorted[i];
        }
    }

    @org.junit.jupiter.api.Test
    void testCase4() {
        int size = 1000;
        Integer[] array = new Integer[size];
        for (int i =0; i < size; i++ ) {
            array[i] = (int) (Math.random()*size);
        }
        Integer[] arraySorted = HeapSorter.sort(array);
        Integer[] arrayExpected = array.clone();
        Arrays.sort(arrayExpected);

//        System.out.println(Arrays.toString(arraySorted));
//        System.out.println(Arrays.toString(arrayExpected));
//        Integer previous = Integer.MIN_VALUE;
        for (int i =0; i < size; i++ ) {
//            assertTrue(arraySorted[i] >= previous);
//            previous = arraySorted[i];
            assertEquals(arrayExpected[i], arraySorted[i]);

        }
    }

    @org.junit.jupiter.api.Test
    void testCase5() {
        int size = 100000;
        Integer[] array = (Integer[]) distinctRandomIntegers(size);
        Heap heap = new Heap<>(size);
        for (int i =0; i < size; i++ ) {
            heap.insert(array[i]);
        }
        Integer[] arrayExpected = array.clone();
        Arrays.sort(arrayExpected);
//        System.out.println(Arrays.toString(arrayExpected));
        for (int i =0; i < size; i++ ) {
            assertEquals(arrayExpected[i], heap.deleteMin());
        }

    }
}