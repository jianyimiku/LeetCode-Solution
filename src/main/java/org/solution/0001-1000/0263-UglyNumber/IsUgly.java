
@SuppressWarnings("all")
class IsUgly {
    public boolean isUgly(int n) {
        if (n < 1) {
            return false;
        }
        // 只有 2  3  5 说明只能被2 3 5除
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        return n == 1;
    }
}