public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        //the largest consecutive sum ending at the index
        int[] subSum = new int[nums.length];
        subSum[0] = nums[0];
        int max = subSum[0];
        for (int i = 1; i < nums.length; i++) {
            subSum[i] = Math.max(subSum[i - 1] + nums[i], nums[i]);
            max = Math.max(max, subSum[i]);
        }
        return max;
    }
}