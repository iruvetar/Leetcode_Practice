public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (target > nums[end]) {
            return end + 1;
        }
        if (target == nums[end] || target > nums[start]) {
            return end;
        }
        if (target <= nums[start]) {
            return start;
        }
        return 0;
    }
}