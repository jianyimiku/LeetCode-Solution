/**
 * @author ：sjq
 * @date ：Created in 2022/8/29 09:04
 * @description：
 * @modified By：
 * @version: $
 */
@SuppressWarnings("all")
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String var1 = getPalindromic(i, i, s);
            String var2 = getPalindromic(i, i + 1, s);
            int maxLen = Math.max(var1.length(), var2.length());
            if (maxLen > res.length()) {
                res = var1.length() >= var2.length() ? var1 : var2;
            }
        }
        return res;
    }


    private String getPalindromic(int i, int j, String s) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }


    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring
                = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome("cbbd"));
    }
}
