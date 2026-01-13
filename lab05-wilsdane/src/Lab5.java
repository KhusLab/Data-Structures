public class Lab5 extends AbstractLab5 {
    static String greedyActivitySelector(int[] s, int[] f, int k, int n) {
        StringBuilder result = new StringBuilder();

        // first always selected
        int m = k + 1;
        while (m <= n && s[m] < f[k]) {
            m++;
        }

        if (m <= n) {
            result.append(m).append(",");
            result.append(greedyActivitySelector(s, f, m, n));
        }

        return result.toString();
    }
}
