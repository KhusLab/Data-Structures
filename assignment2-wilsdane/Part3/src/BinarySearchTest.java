import java.util.Arrays;
import java.util.Random;

public class BinarySearchTest {
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10_000, 100_000, 1_000_000, 10_000_000, 100_000_000};
        Random random = new Random();

        System.out.printf("%-15s %-15s %-15s%n", "Size", "Linear (ms)", "Binary (ms)");

        for (int size : sizes) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = random.nextInt(Integer.MAX_VALUE);
            }

            // Sort array for binary search
            Arrays.sort(array);

            // Choose a random target from the array
            int targetIndex = random.nextInt(size);
            int target = array[targetIndex];

            // Measure linear search time
            long startLinear = System.currentTimeMillis();
            for (int i = 0; i < size; i++) {
                if (array[i] == target) {
                    break;
                }
            }
            long endLinear = System.currentTimeMillis();

            // Measure binary search time
            long startBinary = System.currentTimeMillis();
            int result = Arrays.binarySearch(array, target);
            long endBinary = System.currentTimeMillis();

            System.out.printf("%-15d %-15d %-15d%n",
                    size, (endLinear - startLinear), (endBinary - startBinary));
        }
    }
}
