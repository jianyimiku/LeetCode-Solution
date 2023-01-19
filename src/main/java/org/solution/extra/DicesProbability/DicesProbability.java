package org.solution.extra.DicesProbability;

import java.util.Arrays;

@SuppressWarnings("all")
public class DicesProbability {
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        // 从2个骰子开始
        for (int i = 2; i <= n; i++) {
            // 和种数有[n,6n] 5n + 1种
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    // 因为 dp[j] += dp[j - k] * 1/6 但是 j-k会有越界问题 所以我们可以反向
                    // dp[j]的概率为 dp[j+1] dp[j+2] .... dp[j+6] 做了贡献
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }

    public static void main(String[] args) {
        DicesProbability dicesProbability = new DicesProbability();
        System.out.println(Arrays.toString(dicesProbability.dicesProbability(2)));
    }
}