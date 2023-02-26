/**
 * 给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。
 * <p>
 * 10 / 3 = 3
 * 7 / -3 = -2
 */
@SuppressWarnings("all")
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        long x = dividend, y = divisor;
        boolean isNeg = false;
        if ((x > 0 && y < 0) || (x < 0 && y > 0)) isNeg = true;
        if (x < 0) x = -x;
        if (y < 0) y = -y;
        long l = 0, r = x;
        // 二分查找
        while (l < r) {
            long middle = l + ((r - l + 1) >> 1);
            if (mul(middle, y) <= x) {
                l = middle;
            } else {
                r = middle - 1;
            }
        }
        long ans = isNeg ? -l : l;
        // 因为除以一个(0,1)的可能会发生溢出
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
            return ans > Integer.MAX_VALUE ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return (int) ans;
    }

    /**
     * 快速乘法 记住模版
     * @param a
     * @param b
     * @return
     */
    private long mul(long a, long b) {
        long ans = 0;
        while (b > 0) {
            if ((b & 1) == 1) ans += a;
            b >>= 1;
            a += a;
        }
        return ans;
    }

    public static void main(String[] args) {
        DivideTwoIntegers twoIntegers = new DivideTwoIntegers();
        System.out.println(twoIntegers.divide(7, -3));
    }
}