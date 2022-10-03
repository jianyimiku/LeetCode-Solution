import java.util.HashMap;

@SuppressWarnings("all")
class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s.length() == 1) {
            return s.length();
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            int value = hashMap.getOrDefault(c, 0);
            hashMap.put(c, ++value);
        }
        int res = 0;
        for (Integer ans : hashMap.values()) {
            res += ans / 2 * 2;
            if (ans % 2 == 1 && res % 2 == 0) {
                res++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("abccccdd"));
    }
}