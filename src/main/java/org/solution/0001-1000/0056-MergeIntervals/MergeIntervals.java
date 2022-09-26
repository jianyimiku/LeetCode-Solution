import java.util.Arrays;

@SuppressWarnings("all")
class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        // 排序变为有序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] ints = intervals[i];
            if (ints[0] <= intervals[index][1]) {
                // 注意点
                intervals[index][1] = Math.max(ints[1], intervals[index][1]);
            } else {
                intervals[++index] = ints;
            }
        }
        int[][] res = new int[index + 1][];
        for (int i = 0; i <= index; i++) {
            res[i] = intervals[i];
        }
        return res;
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals
                = new MergeIntervals();
        System.out.println(Arrays.deepToString(mergeIntervals.merge(new int[][]{
                {1, 4}, {4, 5}
        })));
    }
}