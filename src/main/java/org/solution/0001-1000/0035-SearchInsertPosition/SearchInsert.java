@SuppressWarnings("all")
class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while(left < right){
            int middle = left + (right - left) / 2;
            if(nums[middle] == target){
                return middle;
            }else if(nums[middle] < target){
                left = middle + 1;
            }else{
                right = middle;
            }
        }
        if(nums[left] < target){
            return left + 1;
        }
        return left;
    }
}