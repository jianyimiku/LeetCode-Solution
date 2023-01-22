import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 滑动窗口题目
 * <p>
 * 右边往后移到有k个0结束
 */
@SuppressWarnings("all")
public class LongestOnes {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                k--;
            }
            while (k < 0) {
                if (nums[left] == 0) {
                    k++;
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }


    public static void main(String[] args) {
        LongestOnes longestOnes = new LongestOnes();
        System.out.println(longestOnes
                .longestOnes(new int[]{0, 0, 1, 1, 1, 0, 0}, 0));
    }
}