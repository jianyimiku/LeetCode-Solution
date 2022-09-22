@SuppressWarnings("all")
class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int res = 0;
        int origin = x;
        while (x != 0) {
            res = res * 10 + (x % 10);
            x /= 10;
        }
        return res == origin;
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber
                = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(121));
    }
}