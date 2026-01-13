public class Sort {
    public static <T extends Comparable<T>> T[] insertionSort(T[] a) {
        // Implement your solution here
        // Do not change the function's signature
        for (int i = 1; i < a.length; i++) {
            T key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j].compareTo(key) > 0) {
                    a[j + 1] = a[j];
                    j--;
            }
            a[j + 1] = key;
        }
        return a;
    }

    public static <T extends Comparable<T>> T[] shellSort(T[] a) {
        // Implement your solution here
        // Do not change the function's signature
        int n = a.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                T temp = a[i];
                int j = i;
                while (j >= gap && a[j - gap].compareTo(temp) > 0) {
                    a[j] = a[j - gap];
                    j -= gap;
                }
                a[j] = temp;
            }
        }
        return a;
    }
}
