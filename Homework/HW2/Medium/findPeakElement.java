public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) { //ensure that there must be at least 3 elements 
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            } else if (nums[mid] < nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                start = mid; //move toward the larger side
            } else if (nums[mid] > nums[mid + 1] && nums[mid] < nums[mid - 1]) {
                end = mid;
            } else { //when middle is the lowest point
                start = mid;
            }
        }
        if (nums[start] > nums[end]) {
            return start;
        } else {
            return end;
        }
    }
}