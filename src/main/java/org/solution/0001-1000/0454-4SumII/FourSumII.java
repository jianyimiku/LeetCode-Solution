import java.util.Arrays;
import java.util.HashMap;

@SuppressWarnings("all")
public class FourSumII {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int count = 0;
        int len = nums1.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int cur = nums1[i] + nums2[j];
                if (hashMap.containsKey(cur)) {
                    Integer integer = hashMap.get(cur);
                    hashMap.put(cur, ++integer);
                } else {
                    hashMap.put(cur, 1);
                }
            }
        }

        for (int k = 0; k < len; k++) {
            for (int l = 0; l < len; l++) {
                int cur = 0 - nums3[k] - nums4[l];
                if (hashMap.containsKey(cur)) {
                    count += hashMap.get(cur);
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        FourSumII fourSumII = new FourSumII();
        System.out.println(fourSumII.fourSumCount(new int[]{-1, -1}, new int[]{-1, 1},
                new int[]{-1, 1}, new int[]{-1, 1}));
    }
}