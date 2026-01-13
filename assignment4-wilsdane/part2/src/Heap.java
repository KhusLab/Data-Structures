public class Heap<T extends Comparable<T>> {

    // Implement your solution
    private T[] array;
    private int currentSize;
    public int size;

    public Heap() {
        array = (T[]) new Comparable[2];
        currentSize = 0;
    }

    public Heap(int capacity) {
        array = (T[]) new Comparable[capacity + 1];
        currentSize = 0;
    }

    public Heap(T[] items) {
        currentSize = items.length;
        array = (T[]) new Comparable[currentSize + 1];
        for (int i = 0; i < currentSize; i++) {
            array[i + 1] = items[i];
        }
        size= currentSize;
        buildHeap();
    }

    public void insert(T x) {
        if (currentSize == array.length - 1) {
            enlargeArray(array.length * 2);
        }

        int hole = ++currentSize;
        array[0] = x;

        while (x.compareTo(array[hole / 2]) < 0) {
            array[hole] = array[hole / 2];
            hole /= 2;
        }

        array[hole] = x;
        size= currentSize;
    }

    public T deleteMin() {
        if (isEmpty()) return null;

        T minItem = array[1];
        array[1] = array[currentSize--];
        percolateDown(1);
        size= currentSize;
        return minItem;
    }

    public void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--) {
            percolateDown(i);
        }
    }

    private void percolateDown(int hole) {
        int child;
        T tmp = array[hole];

        while (hole * 2 <= currentSize) {
            child = hole * 2;
            if (child != currentSize && array[child + 1].compareTo(array[child]) < 0) {
                child++;
            }

            if (array[child].compareTo(tmp) < 0) {
                array[hole] = array[child];
            } else {
                break;
            }
            hole = child;
        }

        array[hole] = tmp;
    }

    private void enlargeArray(int newSize) {
        T[] old = array;
        array = (T[]) new Comparable[newSize];
        for (int i = 0; i < old.length; i++) {
            array[i] = old[i];
        }
    }

    private boolean isEmpty() {
        return currentSize == 0;
    }

    public T[] getHeap() {
        T[] result = (T[]) new Comparable[currentSize + 1];
        for (int i = 1; i <= currentSize; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static Integer[] sort(Integer[] numbers) {
        Heap<Integer> heap = new Heap<>(numbers);
        Integer[] sorted = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            sorted[i] = heap.deleteMin();
        }
        return sorted;
    }
    public int size() {
        return currentSize;
    }

    public void insertWhile(T x) {
        insert(x);
    }
}
