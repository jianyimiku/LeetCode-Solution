@SuppressWarnings("all")
class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int m = prices.length;
        int[][] dp = new int[m][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < m; i++) {
            // 当天不持有股票 那么最大收益就是 卖出 或者 不动
            dp[i][0] = Math.max(dp[i - 1][0], prices[i] + dp[i - 1][1]);
            // 因为只可以买入一次
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[m - 1][0];
    }
}