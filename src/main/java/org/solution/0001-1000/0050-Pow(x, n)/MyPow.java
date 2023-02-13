@SuppressWarnings("all")
public class MyPow {
    public double myPow(double x, int n) {
        // 如果是0
        if (x == 0.0f) {
            return 0.0;
        }
        double res = 1.0;
        long b = n;

        if (b < 0) {
            x = 1 / x;
            b = -b;
        }

        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }

        return res;
    }
}