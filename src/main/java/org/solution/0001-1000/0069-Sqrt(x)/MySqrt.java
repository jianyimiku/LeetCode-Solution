@SuppressWarnings("all")
class MySqrt {
    public static int mySqrt(int x) {
        long l = 0;
        long r = x;
        while (l < r) {
            long mid = l + (r - l + 1) / 2;
            if (mid * mid > x) {
                r = mid - 1;
            } else if (mid * mid == x) {
                return (int) mid;
            } else {
                l = mid;
            }
        }
        return (int) l;
    }


    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }
}