import java.util.HashMap;

/**
 * @author ：sjq
 * @date ：Created in 2022/8/25 08:33
 * @description：解决方法: 使用Map来记录出现过的元素和其索引的位置
 * @modified By：
 * @version: $
 */
@SuppressWarnings("all")
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int needEle = target - nums[i];
            if (hashMap.containsKey(needEle)) {
                int index = hashMap.get(needEle);
                return new int[]{i, index};
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}
