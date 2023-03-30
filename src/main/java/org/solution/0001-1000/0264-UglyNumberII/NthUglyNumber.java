import java.util.Arrays;

@SuppressWarnings("all")
public class NthUglyNumber {
    // 找出第N个丑数
    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        int a = 0;
        int b = 0;
        int c = 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        // 三个指针分别表示已经插入的 丑数
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[a] * 2, Math.min(dp[b] * 3, dp[c] * 5));
            // 当前插入的是哪个 移动已经表示过的指针
            if (dp[i] == dp[a] * 2) a++;
            if (dp[i] == dp[b] * 3) b++;
            if (dp[i] == dp[c] * 5) c++;
        }
        return dp[n - 1];
    }
}