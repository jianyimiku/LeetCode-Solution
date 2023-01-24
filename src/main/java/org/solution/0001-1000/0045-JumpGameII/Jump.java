import java.util.Arrays;

@SuppressWarnings("all")
public class Jump {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (j + nums[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[nums.length - 1];
    }


    // 2,3,1,1,4  一开始最大边界是 index=2 在遍历2->1这部分的时候可以知道 3可以达到最大边界4 所以当j到2的时候我们更新边界到4
    public int jumpGoodMethod(int[] nums) {
        // 用来记录当前可到的最大边界
        int end = 0;
        // 用来记录这个点最大可到位置
        int maxPosition = 0;
        // 步数
        int steps = 0;
        for (int j = 0; j < nums.length - 1; j++) {
            maxPosition = Math.max(maxPosition, nums[j] + j);
            if (j == end) {
                // 更新当前可达到的最大边界
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }


    public static void main(String[] args) {
        Jump jump = new Jump();
        System.out.println(jump.jumpGoodMethod(new int[]{2, 3, 0, 1, 4}));
    }
}