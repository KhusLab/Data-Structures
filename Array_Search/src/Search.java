public class Search {


    public static int find_first_true(boolean[] A, int begin, int end) {
        // Check if the input range is valid
        if (begin > end || begin < 0 || end > A.length) {
            throw new IllegalArgumentException("Invalid input range");
        }

        for (int i = begin; i < end; i++) {
            if (A[i]) {
                return i;
            }
        }

        return end;
    }


    public static int find_first_equal(int[] A, int x) {
        boolean[] equalArray = new boolean[A.length];

        for (int i = 0; i < A.length; i++) {
            equalArray[i] = (A[i] == x);
        }

        int result = find_first_true(equalArray, 0, equalArray.length);

        return result;
    }

    public static int find_first_true_sorted(boolean[] A, int begin, int end) {
        if (begin > end || begin < 0 || end > A.length) {
            throw new IllegalArgumentException("Invalid input range");
        }
        while (begin < end) {
            int mid = begin + (end - begin) / 2;

            if (A[mid]) {
                if (mid == 0 || !A[mid - 1]) {
                    return mid;
                } else {
                    end = mid;
                }
            } else {
                begin = mid + 1;
            }
        }
        return end;
    }



}

