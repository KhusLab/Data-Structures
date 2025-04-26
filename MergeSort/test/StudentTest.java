import java.util.ArrayList;

public class StudentTest {
    private static int testCount = 0;
    private static int passedCount = 0;

    private static void assertEquals(Object expected, Object actual) {
        testCount++;
        if (!expected.equals(actual)) {
            System.err.println("Test failed: expected " + expected + " but got " + actual);
        } else {
            passedCount++;
        }
    }

    private static void assertTrue(boolean condition) {
        testCount++;
        if (!condition) {
            System.err.println("Test failed: expected true but got false");
        } else {
            passedCount++;
        }
    }

    private static void assertNull(Object obj) {
        testCount++;
        if (obj != null) {
            System.err.println("Test failed: expected null but got " + obj);
        } else {
            passedCount++;
        }
    }

    private static void testDistance() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1); list.add(2); list.add(3);
        ArrayListIterator begin = new ArrayListIterator(list, 0);
        ArrayListIterator end = new ArrayListIterator(list, 3);
        assertEquals(3, MergeSort.distance(begin, end));
    }

    private static void testCopy() {
        ArrayList<Integer> source = new ArrayList<>();
        source.add(1); source.add(2); source.add(3);
        ArrayList<Integer> dest = new ArrayList<>();
        dest.add(0); dest.add(0); dest.add(0);
        
        ArrayListIterator srcBegin = new ArrayListIterator(source, 0);
        ArrayListIterator srcEnd = new ArrayListIterator(source, 3);
        ArrayListIterator destBegin = new ArrayListIterator(dest, 0);
        
        MergeSort.copy(srcBegin, srcEnd, destBegin);
        assertEquals(source, dest);
    }

    private static void testMakeArray() {
        ArrayList<Integer> array = MergeSort.make_array(3);
        assertEquals(3, array.size());
        assertNull(array.get(0));
        assertNull(array.get(1));
        assertNull(array.get(2));
    }

    private static void testMerge() {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1); list1.add(3); list1.add(5);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(2); list2.add(4); list2.add(6);
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0); result.add(0); result.add(0); result.add(0); result.add(0); result.add(0);
        
        ArrayListIterator begin1 = new ArrayListIterator(list1, 0);
        ArrayListIterator end1 = new ArrayListIterator(list1, 3);
        ArrayListIterator begin2 = new ArrayListIterator(list2, 0);
        ArrayListIterator end2 = new ArrayListIterator(list2, 3);
        ArrayListIterator resBegin = new ArrayListIterator(result, 0);
        
        MergeSort.merge(begin1, end1, begin2, end2, resBegin);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1); expected.add(2); expected.add(3); expected.add(4); expected.add(5); expected.add(6);
        assertEquals(expected, result);
    }

    private static void testSortEmpty() {
        ArrayList<Integer> empty = new ArrayList<>();
        ArrayListIterator begin = new ArrayListIterator(empty, 0);
        ArrayListIterator end = new ArrayListIterator(empty, 0);
        MergeSort.sort(begin, end);
        assertTrue(empty.isEmpty());
    }

    private static void testSortSingleElement() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(42);
        ArrayListIterator begin = new ArrayListIterator(list, 0);
        ArrayListIterator end = new ArrayListIterator(list, 1);
        MergeSort.sort(begin, end);
        assertEquals(1, list.size());
        assertEquals(42, (int)list.get(0));
    }

    private static void testSortAlreadySorted() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1); list.add(2); list.add(3);
        ArrayListIterator begin = new ArrayListIterator(list, 0);
        ArrayListIterator end = new ArrayListIterator(list, 3);
        MergeSort.sort(begin, end);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1); expected.add(2); expected.add(3);
        assertEquals(expected, list);
    }

    private static void testSortReverseSorted() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3); list.add(2); list.add(1);
        ArrayListIterator begin = new ArrayListIterator(list, 0);
        ArrayListIterator end = new ArrayListIterator(list, 3);
        MergeSort.sort(begin, end);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1); expected.add(2); expected.add(3);
        assertEquals(expected, list);
    }

    private static void testSortWithDuplicates() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3); list.add(1); list.add(2); list.add(1);
        ArrayListIterator begin = new ArrayListIterator(list, 0);
        ArrayListIterator end = new ArrayListIterator(list, 4);
        MergeSort.sort(begin, end);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1); expected.add(1); expected.add(2); expected.add(3);
        assertEquals(expected, list);
    }

    private static void testSortLargeRandom() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add((int)(Math.random() * 1000));
        }
        ArrayListIterator begin = new ArrayListIterator(list, 0);
        ArrayListIterator end = new ArrayListIterator(list, 1000);
        MergeSort.sort(begin, end);
        for (int i = 1; i < list.size(); i++) {
            assertTrue(list.get(i-1) <= list.get(i));
        }
    }

    public static void main(String[] args) {
        testDistance();
        testCopy();
        testMakeArray();
        testMerge();
        testSortEmpty();
        testSortSingleElement();
        testSortAlreadySorted();
        testSortReverseSorted();
        testSortWithDuplicates();
        testSortLargeRandom();

        System.out.println("\nTest results: " + passedCount + "/" + testCount + " passed");
        if (passedCount == testCount) {
            System.out.println("All tests passed successfully!");
        } else {
            System.out.println((testCount - passedCount) + " tests failed");
        }
    }
}
