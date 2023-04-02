@SuppressWarnings("all")
public class MaxSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 以 i 和 j为右下角的正方形所能构成的最大边长
        // 证明 https://leetcode.cn/problems/count-square-submatrices-with-all-ones/solution/tong-ji-quan-wei-1-de-zheng-fang-xing-zi-ju-zhen-2/
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    // Remember 取附近的最小的那个边
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max * max;
    }
}