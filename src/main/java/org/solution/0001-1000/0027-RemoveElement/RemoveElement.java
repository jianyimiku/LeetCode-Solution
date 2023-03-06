
@SuppressWarnings("all")
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = -1;
        int j = 0;
        int n = nums.length;
        while (j < n) {
            if (nums[j] != val) {
                swap(nums, i + 1, j);
                i++;
            }
            j++;
        }
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        RemoveElement element = new RemoveElement();
        System.out.println(element
                .removeElement(new int[]{3, 2, 2, 3}, 2));
    }
}