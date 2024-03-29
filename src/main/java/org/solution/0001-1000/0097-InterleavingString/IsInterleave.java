@SuppressWarnings("all")
public class IsInterleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) return false;
        // 表示s1的前i个字符 和 s2的前J个字符是否可以组成 s3 i+j
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s2.length(); i++) {
            // 遇到相同继续向后 不同后面也没有意义了
            if (s3.charAt(i - 1) == s2.charAt(i - 1)) {
                dp[0][i] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= s1.length(); i++) {
            if (s3.charAt(i - 1) == s1.charAt(i - 1)) {
                dp[i][0] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                dp[i][j] = (dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1))
                        || (dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1));
            }
        }
        return dp[s1.length()][s2.length()];
    }
} 