public class Lab6 extends AbstractLab6 {

    // Negative infinity constant
    static double negativeInfinityDouble = Double.NEGATIVE_INFINITY;

    public static double cutRodBottomUp(double[] p,int n) {
        double[] r = new double[n + 1];
        r[0] = 0;

        for (int j = 1; j <= n; j++) {
            double q = 0;  // initialize q to 0 to handle negative prices
            for (int i = 1; i <= Math.min(j, p.length); i++) {
                q = Math.max(q, p[i - 1] + r[j - i]);
            }
            r[j] = q;
        }

        return r[n];
    }
}
