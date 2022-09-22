/**
 * @author ：sjq
 * @date ：Created in 2022/8/26 08:53
 * @description：
 * @modified By：
 * @version: $
 */
@SuppressWarnings("all")
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    /**
     * 查找第K个元素
     * @param nums1 第一个有序数组
     * @param i 当前递归中有序数组的起始位置
     * @param nums2 第二个有序数组
     * @param j 当前递归中有序数组的起始位置
     * @param k 当前判断第几个元素
     * @return
     */
    public int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        // nums1为空数组 表名第K个元素肯定不在nums1中 那么直接到nums2中找
        if (i >= nums1.length) {
            return nums2[j + k - 1];
        }
        //nums2为空数组
        if (j >= nums2.length) {
            return nums1[i + k - 1];
        }
        // 如果找第一个元素
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (midVal1 < midVal2) {
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }
}
