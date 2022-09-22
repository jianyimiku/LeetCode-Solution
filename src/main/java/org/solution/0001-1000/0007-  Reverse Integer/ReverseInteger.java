@SuppressWarnings("all")
class ReverseInteger {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (x < 0 && ((res < Integer.MIN_VALUE / 10) || (res == Integer.MIN_VALUE / 10 && x < Integer.MIN_VALUE % 10))) {
                return 0;
            }
            if (x > 0 && ((res > Integer.MAX_VALUE / 10) || (res == Integer.MAX_VALUE / 10 && x > Integer.MAX_VALUE % 10))) {
                return 0;
            }
            res = res * 10 + (x % 10);
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(Integer.MIN_VALUE));
    }
}