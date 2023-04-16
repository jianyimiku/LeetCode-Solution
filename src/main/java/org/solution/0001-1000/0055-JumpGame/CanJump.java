@SuppressWarnings("all")
class CanJump {
    // 3,2,1,0,4
    public boolean canJump(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) return false;
            // k在当前位置最大可达到的位置
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }
}